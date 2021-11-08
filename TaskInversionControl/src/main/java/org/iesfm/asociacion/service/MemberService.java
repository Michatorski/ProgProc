package org.iesfm.asociacion.service;

import org.iesfm.asociacion.Member;
import org.iesfm.asociacion.dao.MemberDAO;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MemberService implements MemberDAO {
    private Map<String, Member> members = new HashMap<>();

    private NamedParameterJdbcTemplate jdbc;

    @Override
    public List<Member> list() {
        return new LinkedList<>(members.values());
    }

    @Override
    public void insert(Member member) {
        members.put(member.getNif(), member);

    }

    @Override
    public void delete(String memberNif) {
        members.remove(memberNif);
    }

    @Override
    public void modify( Member updateMember) {
        members.replace(updateMember.getNif(), updateMember);
    }
}
