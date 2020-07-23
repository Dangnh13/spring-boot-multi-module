package vn.woodsland.byserp.framework.exception.rest.model;

/**
 * Contains all native error codes with appropriate names and messages.
 */
public enum ErrorCode {
	EPERM("EPERM", "Operation not permitted"),
	ENOENT("ENOENT", "No such file or directory"),
	ESRCH("ESRCH", "No such process"),
	EINTR("EINTR", "Interrupted system call"),
	EIO("EIO", "I/O error"),
	ENXIO("ENXIO", "No such device or address"),
	E2BIG("E2BIG", "Argument list too long"),
	ENOEXEC("ENOEXEC", "Exec format error"),
	EBADF("EBADF", "Bad file number"),
	ECHILD("ECHILD", "No child processes"),
	EAGAIN("EAGAIN", "Try again"),
	ENOMEM("ENOMEM", "Out of memory"),
	EACCES("EACCES", "Permission denied"),
	EFAULT("EFAULT", "Bad address"),
	ENOTBLK("ENOTBLK", "Block device required"),
	EBUSY("EBUSY", "Device or resource busy"),
	EEXIST("EEXIST", "File exists"),
	EXDEV("EXDEV", "Cross-device link"),
	ENODEV("ENODEV", "No such device"),
	ENOTDIR("ENOTDIR", "Not a directory"),
	EISDIR("EISDIR", "Is a directory"),
	EINVAL("EINVAL", "Invalid argument"),
	ENFILE("ENFILE", "File table overflow"),
	EMFILE("EMFILE", "Too many open files"),
	ENOTTY("ENOTTY", "Not a typewriter"),
	ETXTBSY("ETXTBSY", "Text file busy"),
	EFBIG("EFBIG", "File too large"),
	ENOSPC("ENOSPC", "No space left on device"),
	ESPIPE("ESPIPE", "Illegal seek"),
	EROFS("EROFS", "Read-only file system"),
	EMLINK("EMLINK", "Too many links"),
	EPIPE("EPIPE", "Broken pipe"),
	EDOM("EDOM", "Argument out of range"),
	ERANGE("ERANGE", "Result too large"),
	EDEADLK("EDEADLK", "Resource deadlock would occur"),
	ENAMETOOLONG("ENAMETOOLONG", "Name too long"),
	ENOLCK("ENOLCK", "No record locks available"),
	ENOSYS("ENOSYS", "Function not implemented"),
	ENOTEMPTY("ENOTEMPTY", "must not be empty"),
	ELOOP("ELOOP", "Too many symbolic links"),
	ENOMSG("ENOMSG", "No errorMessage of desired type"),
	EIDRM("EIDRM", "Identifier removed"),
	ECHRNG("ECHRNG", "Channel number out of range"),
	EL2NSYNC("EL2NSYNC", "Level 2 not synchronized"),
	EL3HLT("EL3HLT", "Level 3 halted"),
	EL3RST("EL3RST", "Level 3 reset"),
	ELNRNG("ELNRNG", "Link number out of range"),
	EUNATCH("EUNATCH", "Protocol driver not attached"),
	ENOCSI("ENOCSI", "No CSI structure available"),
	EL2HLT("EL2HLT", "Level 2 halted"),
	EBADE("EBADE", "Invalid exchange"),
	EBADR("EBADR", "Invalid request descriptor"),
	EXFULL("EXFULL", "Exchange full"),
	ENOANO("ENOANO", "No anode"),
	EBADRQC("EBADRQC", "Invalid request errorCode"),
	EBADSLT("EBADSLT", "Invalid slot"),
	EBFONT("EBFONT", "Bad font file format"),
	ENOSTR("ENOSTR", "Not a stream"),
	ENODATA("ENODATA", "No data available"),
	ETIME("ETIME", "Stream timeout"),
	ENOSR("ENOSR", "Out of streams resources"),
	ENONET("ENONET", "Machine is not on the network"),
	ENOPKG("ENOPKG", "Package not installed"),
	EREMOTE("EREMOTE", "Object is remote"),
	ENOLINK("ENOLINK", "Link has been severed"),
	EADV("EADV", "Advertise error"),
	ESRMNT("ESRMNT", "Srmount error"),
	ECOMM("ECOMM", "Communication error on send"),
	EPROTO("EPROTO", "Protocol error"),
	EMULTIHOP("EMULTIHOP", "Multihop attempted"),
	EDOTDOT("EDOTDOT", "RFS specific error"),
	EBADMSG("EBADMSG", "Not a data errorMessage"),
	EOVERFLOW("EOVERFLOW", "Value too large for defined data type"),
	ENOTUNIQ("ENOTUNIQ", "Name not unique on network"),
	EBADFD("EBADFD", "File descriptor in bad state"),
	EREMCHG("EREMCHG", "Remote address changed"),
	ELIBACC("ELIBACC", "Can not access a needed shared library"),
	ELIBBAD("ELIBBAD", "Accessing a corrupted shared library"),
	ELIBSCN("ELIBSCN", ".lib section in a.out corrupted"),
	ELIBMAX("ELIBMAX", "Attempting to link in too many shared libraries"),
	ELIBEXEC("ELIBEXEC", "Cannot exec a shared library directly"),
	EILSEQ("EILSEQ", "Illegal byte sequence"),
	ERESTART("ERESTART", "Interrupted system call should be restarted"),
	ESTRPIPE("ESTRPIPE", "Streams pipe error"),
	EUSERS("EUSERS", "Too many users"),
	ENOTSOCK("ENOTSOCK", "Socket operation on non-socket"),
	EDESTADDRREQ("EDESTADDRREQ", "Destination address required"),
	EMSGSIZE("EMSGSIZE", "errorMessage too long"),
	EPROTOTYPE("EPROTOTYPE", "Protocol wrong type for socket"),
	ENOPROTOOPT("ENOPROTOOPT", "Protocol not available"),
	EPROTONOSUPPORT("EPROTONOSUPPORT", "Protocol not supported"),
	ESOCKTNOSUPPORT("ESOCKTNOSUPPORT", "Socket type not supported"),
	EOPNOTSUPP("EOPNOTSUPP", "Operation not supported on transport endpoint"),
	EPFNOSUPPORT("EPFNOSUPPORT", "Protocol family not supported"),
	EAFNOSUPPORT("EAFNOSUPPORT", "Address family not supported by protocol"),
	EADDRINUSE("EADDRINUSE", "Address already in use"),
	EADDRNOTAVAIL("EADDRNOTAVAIL", "Cannot assign requested address"),
	ENETDOWN("ENETDOWN", "Network is down"),
	ENETUNREACH("ENETUNREACH", "Network is unreachable"),
	ENETRESET("ENETRESET", "Network dropped connection because of reset"),
	ECONNABORTED("ECONNABORTED", "Software caused connection abort"),
	ECONNRESET("ECONNRESET", "Connection reset by peer"),
	ENOBUFS("ENOBUFS", "No buffer space available"),
	EISCONN("EISCONN", "Transport endpoint is already connected"),
	ENOTCONN("ENOTCONN", "Transport endpoint is not connected"),
	ESHUTDOWN("ESHUTDOWN", "Cannot send after transport endpoint shutdown"),
	ETOOMANYREFS("ETOOMANYREFS", "Too many references: cannot splice"),
	ETIMEDOUT("ETIMEDOUT", "Connection timed out"),
	ECONNREFUSED("ECONNREFUSED", "Connection refused"),
	EHOSTDOWN("EHOSTDOWN", "Host is down"),
	EHOSTUNREACH("EHOSTUNREACH", "No route to host"),
	EALREADY("EALREADY", "Operation already in progress"),
	EINPROGRESS("EINPROGRESS", "Operation now in progress"),
	ESTALE("ESTALE", "Stale NFS file handle"),
	EUCLEAN("EUCLEAN", "Structure needs cleaning"),
	ENOTNAM("ENOTNAM", "Not a XENIX named type file"),
	ENAVAIL("ENAVAIL", "No XENIX semaphores available"),
	EISNAM("EISNAM", "Is a named type file"),
	EREMOTEIO("EREMOTEIO", "Remote I/O error"),
	EDQUOT("EDQUOT", "Quota exceeded"),
	ENOMEDIUM("ENOMEDIUM", "No medium found"),
	EMEDIUMTYPE("EMEDIUMTYPE", "Wrong medium type"),
	ECANCELED("ECANCELED", "Operation Canceled"),
	ENOKEY("ENOKEY", "Required key not available"),
	EKEYEXPIRED("EKEYEXPIRED", "Key has expired"),
	EKEYREVOKED("EKEYREVOKED", "Key has been revoked"),
	EKEYREJECTED("EKEYREJECTED", "Key was rejected by service"),
	EOWNERDEAD("EOWNERDEAD", "Owner died"),
	ENOTRECOVERABLE("ENOTRECOVERABLE", "State not recoverable"),
	ECOPYBEAN("ECOPYBEAN", "Cannot copy bean"),
	ESENDMAIL("ESENDMAIL", "Cannot send mail"),
	EDATEFORMAT("EDATEFORMAT", "Date format not recognized"),
	ETIMEFRAME("ETIMEFRAME", "Time Request not available"),
	EUNKNOWN("EUNKNOWN", "Unknown error"),
	EUNAUTHORIZED("UNAUTHORIZED", "UNAUTHORIZED");

	private final String errorCode;
	private final String errorMessage;

	ErrorCode(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}


	/**
	 * @param errorCode the error code
	 * @return appropriate name of the error depending on the code
	 */
	public static String getErrorName(String errorCode) {
		ErrorCode error = ErrorCode.getEnum(errorCode);
		if (error != null) {
			return error.name();
		}
		return "UNKNOWN_ERROR";
	}

	/**
	 * @param errorCode the error code
	 * @return appropriate message containing an explanation of the code
	 */
	public static String getErrorMessage(String errorCode) {
		ErrorCode error = ErrorCode.getEnum(errorCode);
		if (error != null) {
			return error.getErrorMessage();
		}
		return String.format("Unknown error code: %d", errorCode);
	}

	/**
	 * @param errorCode the error code
	 * @return the ErrorCode enum representing the error code
	 */
	public static ErrorCode getEnum(String errorCode) {
		for (ErrorCode value : values()) {
			if (value.errorCode == errorCode) {
				return value;
			}
		}
		return null;
	}
}
