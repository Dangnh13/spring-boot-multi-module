package vn.woodsland.byserp.dto.base;

public class Meta {

	public static final Meta OK = new Meta(200);

	int code;

	public Meta() {
		super();
	}

	public Meta(int code) {
		super();
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
