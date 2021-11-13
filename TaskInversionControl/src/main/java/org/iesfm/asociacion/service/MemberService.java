package org.iesfm.asociacion.service;

import org.iesfm.asociacion.Member;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MemberService {
    private Map<String, Member> members = new HashMap<>();


    public List<Member> list() {
        return new LinkedList<>(members.values());
    }


    public void insert(Member member) {
        members.put(member.getNif(), member);
    }


    public void delete(String memberNif) {
        members.remove(memberNif);
    }


    public void modify(Member updateMember) {
        members.replace(updateMember.getNif(), updateMember);
    }
}
