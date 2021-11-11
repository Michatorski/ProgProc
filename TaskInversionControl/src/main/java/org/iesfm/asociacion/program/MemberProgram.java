package org.iesfm.asociacion.program;

import org.iesfm.asociacion.Member;
import org.iesfm.asociacion.reader.MemberReader;
import org.iesfm.asociacion.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

public class MemberProgram {
    private static final Logger log = LoggerFactory.getLogger(MemberProgram.class);

    private MemberReader reader;

    private MemberService service;

    private List<Member> members = new LinkedList<>();

    public MemberProgram(MemberReader reader, MemberService service) {
        this.reader = reader;
        this.service = service;
    }

    public void list(){
        members = service.list();
        if (members.isEmpty()){
            log.info("Lista esta vacia, es necesario un insert" + "\n");
        } else {
            for (Member member : members) {
                log.info(member.toString() + "\n");
            }
        }
    }

    public void insert(){
        Member member = reader.readMember();
        service.insert(member);
    }

    public void modify(){
        service.modify(reader.readMember());
    }
    public void delete(String nif){
        service.delete(nif);
    }

}
