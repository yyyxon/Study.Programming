package com.yeon.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yeon.domain.DeptDomain;

import jakarta.annotation.Resource;

@Mapper
@Resource
public interface DeptMapper {
	
	//public List<String> selectDname();
	public List<DeptDomain> selectAllDept();

}
