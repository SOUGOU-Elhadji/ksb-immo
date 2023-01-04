package sn.ksb.immo.ksbimmo.generatecontract.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.ksb.immo.ksbimmo.generatecontract.model.File;

public interface FileRepo extends JpaRepository<File,String> {
}
