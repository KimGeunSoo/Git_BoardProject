package kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.MemberDAO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO mdao;

}