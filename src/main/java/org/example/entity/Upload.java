package org.example.entity;

import org.springframework.stereotype.Component;

/**
 * UserTable entity. @author MyEclipse Persistence Tools
 */

@Component
public class Upload{
	
	private Integer id;
	private Integer userid;
	private String path;
	private String filename;
	
	public Upload() {
	}
	public Upload(Integer userid) {
		super();
		this.userid = userid;
	}

	public Upload(Integer userid, String path, String filename) {
		super();
		this.userid = userid;
		this.path = path;
		this.filename = filename;
	}
	
	public Upload(Integer id, Integer userid, String path, String filename) {
		super();
		this.filename = filename;
		this.id = id;
		this.path = path;
		this.userid = userid;
	}

	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}
	/**
	 * @return the userid
	 */
	public Integer getUserid() {
		return userid;
	}
	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "Upload{" +
				"id=" + id +
				", userid=" + userid +
				", path='" + path + '\'' +
				", filename='" + filename + '\'' +
				'}';
	}
}