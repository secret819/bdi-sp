package com.bdi.sp.vo;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("bi")
public class BoardInfo {
	
	private Integer binum;
	private String bititle;
	private String bitext;
	private List<Japan> jList;
	
	
	
	public List<Japan> getjList() {
		return jList;
	}
	public void setjList(List<Japan> jList) {
		this.jList = jList;
	}
	public Integer getBinum() {
		return binum;
	}
	public void setBinum(Integer binum) {
		this.binum = binum;
	}
	public String getBititle() {
		return bititle;
	}
	public void setBititle(String bititle) {
		this.bititle = bititle;
	}
	public String getBitext() {
		return bitext;
	}
	public void setBitext(String bitext) {
		this.bitext = bitext;
	}
	@Override
	public String toString() {
		return "BoardInfo [binum=" + binum + ", bititle=" + bititle + ", bitext=" + bitext + ", jList=" + jList + "]";
	}
	
	
}
