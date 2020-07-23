package vn.woodsland.byserp.framework.util;

import vn.woodsland.byserp.framework.constant.CommonConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

/**
 * General file manipulation utilities.
 * Facilities are provided in the following areas:
 * <p>
 * Writing to a file
 * Create Directory
 * Read file
 * Retrieve extension by file name
 */
@Slf4j
public class FileUtil {

	private FileUtil() {
	}

	/**
	 * Write input stream to file
	 *
	 * @param inputStream data input stream
	 * @param targetFile  file destination
	 * @return boolean greater than 0 is create file success and vice versa
	 * @throws IOException {@link IOException}
	 */
	public static boolean writeFileWithReplace(InputStream inputStream, File targetFile) throws IOException {
		return Files.copy(inputStream, targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING) > 0l;
	}

	/**
	 * Create directory if not exist
	 *
	 * @param directory the target directory
	 * @return boolean true - create dir success, false - create dir failed
	 */
	public static boolean createDirectoryIfNotExist(String directory) {
		try {
			File theDir = new File(directory);
			if (theDir.exists()) {
				log.info("The {} directory had existed", theDir);
				return true;
			}
			theDir.mkdirs();
			log.info("Created {} directory", theDir);
		} catch (Exception e) {
			log.info("Exception: {}", e.getMessage());
			return false;
		}
		return true;
	}

	/**
	 * the method is used to get file from the directory path, the file name and the filename extension.
	 *
	 * @param theDir     the directory path
	 * @param fileName   the file name
	 * @param fileSuffix the file name extension
	 * @return the file from the path
	 */
	public static File getFileOf(String theDir, String fileName, String fileSuffix) {
		return new File(StringUtils.join(theDir, CommonConstant.SYMBOL.SLASH_SYMBOL, fileName, fileSuffix));
	}

	/**
	 * Check multipartFile is not empty or not
	 *
	 * @param multipartFile data for checking
	 * @return true-empty, false- not empty
	 */
	public static boolean isNotEmptyMultipartFile(MultipartFile multipartFile) {
		return (multipartFile != null && !multipartFile.isEmpty() && multipartFile.getSize() > 0);
	}

	/**
	 * The method to read data of file in byte format with directory, filename and file extension.
	 * <i>
	 * if file not exists then return null else return string content of file.
	 * </i>
	 *
	 * @param theDir     the path of directory contains file.
	 * @param fileName   the name of file
	 * @param fileSuffix the extension of file
	 * @return binary content data.
	 */
	public static byte[] readFile(String theDir, String fileName, String fileSuffix) throws IOException {
		byte[] content = null;
		File file = getFileOf(theDir, fileName, fileSuffix);
		if (file.exists()) {
			String path = file.getPath();
			content = Files.readAllBytes(Path.of(path));
		}
		return content;
	}

	/**
	 * Read data of file in byte format
	 *
	 * @param file the target file
	 * @return binary data of file
	 * @throws IOException exception when read file
	 */
	public static byte[] readFile(File file) throws IOException {
		return Files.readAllBytes(Path.of(file.getPath()));
	}


	/**
	 * This method to get the file name extension by a file name
	 *
	 * @param filename the file name
	 * @return the file name extension
	 */
	public static Optional<String> getExtensionByFileName(String filename) {
		return Optional.ofNullable(filename)
				.filter(f -> f.contains(CommonConstant.SYMBOL.DOT_SYMBOL))
				.map(f -> f.substring(filename.lastIndexOf(CommonConstant.SYMBOL.DOT_SYMBOL)));
	}

	/**
	 * Delete file recursive
	 *
	 * @param file target file
	 */
	public static void deleteDir(File file) {
		File[] contents = file.listFiles();
		if (contents != null) {
			for (File f : contents) {
				deleteDir(f);
			}
		}
		file.delete();
	}
}
