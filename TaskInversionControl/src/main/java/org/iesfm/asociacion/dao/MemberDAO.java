package org.iesfm.asociacion.dao;

import org.iesfm.asociacion.Member;

import java.util.List;

public interface MemberDAO {
    List<Member> list();
    void insert(Member member);
    void delete(String memberNif);
    void modify(Member updatedMember);
}
