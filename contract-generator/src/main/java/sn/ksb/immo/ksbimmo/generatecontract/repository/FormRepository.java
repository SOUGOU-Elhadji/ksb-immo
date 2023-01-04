package sn.ksb.immo.ksbimmo.generatecontract.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.ksb.immo.ksbimmo.generatecontract.model.Form;

public interface FormRepository extends JpaRepository<Form, Long> {
}
