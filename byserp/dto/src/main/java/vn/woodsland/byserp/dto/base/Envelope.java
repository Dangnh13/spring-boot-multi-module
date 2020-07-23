package vn.woodsland.byserp.dto.base;

import vn.woodsland.byserp.dto.base.response.RESPONSE;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
@Slf4j
public class Envelope<RES extends RESPONSE> {

	private Meta meta;

	private RES data;

	public Envelope(RES data) {
		this(new Meta(HttpStatus.OK.value()), data);
	}

	public Envelope(Meta meta, RES data) {
		this.setMeta(meta);
		this.setData(data);
	}

	public ResponseEntity<RES> toResponseEntity() {
		return new ResponseEntity<>(getData(), HttpStatus.valueOf(getMeta().getCode()));
	}

}
