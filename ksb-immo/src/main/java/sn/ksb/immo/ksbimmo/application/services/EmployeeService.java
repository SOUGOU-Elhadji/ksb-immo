package sn.ksb.immo.ksbimmo.application.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import sn.ksb.immo.ksbimmo.application.dtos.EmployeeDto;
import sn.ksb.immo.ksbimmo.application.models.Agence;
import sn.ksb.immo.ksbimmo.application.models.Employee;
import sn.ksb.immo.ksbimmo.application.models.Role;
import sn.ksb.immo.ksbimmo.application.repositories.AgenceRepo;
import sn.ksb.immo.ksbimmo.application.repositories.EmployeeRepo;
import sn.ksb.immo.ksbimmo.application.repositories.RoleRepo;

@Service
@Slf4j
@Transactional
public class EmployeeService {
    
    private final EmployeeRepo employeeRepo;

    private final AgenceRepo agenceRepo;

    private final RoleRepo roleRepo;

    private final ModelMapper mapper;

    public EmployeeService(EmployeeRepo employeeRepo, AgenceRepo agenceRepo, RoleRepo roleRepo, ModelMapper mapper) {
        this.employeeRepo = employeeRepo;
        this.agenceRepo = agenceRepo;
        this.roleRepo = roleRepo;
        this.mapper = mapper;
    }

    //récupérer tous les employés
    public List<Employee> getAllEmployees() {
        //log entrée dans la méthode getAllEmployees du service EmployeeService
        log.info("Entrée dans la méthode getAllEmployees du service EmployeeService");
        //initialisation de la liste des employés
        List<Employee> dtos = new ArrayList<>();
        //try catch pour récupérer les employés
        try {
            //récupération des employés
            dtos = employeeRepo.findAll();
            //changer le type de la liste des employés
            /*employees.forEach(employee -> {
                dtos.add(mapper.map(employee, EmployeeDto.class));
            });*/
            //log récupération des employés
            log.info("Récupération des employés");
        } catch (Exception e) {
            //log erreur récupération des employés
            log.error("Erreur lors de la récupération des employés");
        }
        //si la liste est vide
        if (dtos.isEmpty()) {
            //log aucun employé trouvé dans la base de données
            log.error("Aucun employé trouvé dans la base de données");
        }
        //log sortie de la méthode getAllEmployees du service EmployeeService
        log.info("Sortie de la méthode getAllEmployees du service EmployeeService");
        //retourner la liste des employés
        return dtos;
    }

    //récupérer les employées d'une agence
    public List<EmployeeDto> getEmployeesByAgence(String agenceId) {
        //log entrée dans la méthode getEmployeesByAgence du service EmployeeService
        log.info("Entrée dans la méthode getEmployeesByAgence du service EmployeeService");
        //initialisation de la liste des employées
        List<EmployeeDto> dtos = new ArrayList<>();
        //try catch pour récupérer les employées
        try {
            //récupération des employées
            List<Employee> employees = employeeRepo.findByAgence_Id(UUID.fromString(agenceId));
            //changer le type de la liste des employées
            employees.forEach(employee -> {
                dtos.add(mapper.map(employee, EmployeeDto.class));
            });
            //log récupération des employées
            log.info("Récupération des employées");
        } catch (Exception e) {
            //log erreur récupération des employées
            log.error("Erreur lors de la récupération des employées");
        }
        //si la liste est vide
        if (dtos.isEmpty()) {
            //log aucun employé trouvé dans la base de données
            log.error("Aucun employé trouvé dans la base de données pour l'agence d'id : {}" , agenceId);
        }
        //log sortie de la méthode getEmployeesByAgence du service EmployeeService
        log.info("Sortie de la méthode getEmployeesByAgence du service EmployeeService");
        //retourner la liste des employées
        return dtos;
    }

    //récupérer un employé par son matricule
    public EmployeeDto getEmployeeByMatricule(String matricule) {
        //log entrée dans la méthode getEmployeeByMatricule du service EmployeeService
        log.info("Entrée dans la méthode getEmployeeByMatricule du service EmployeeService");
        //initialisation de l'employé
        EmployeeDto employee = null;
        //log matricule
        log.info("Paramètre matricule : {}", matricule);
        //try catch pour récupérer l'employé
        try {
            //récupération de l'employé
            employee = mapper.map(employeeRepo.findByMatricule(matricule), EmployeeDto.class);
            //log récupération de l'employé
            log.info("Récupération de l'employé");
        } catch (Exception e) {
            //log erreur récupération de l'employé
            log.error("Erreur lors de la récupération de l'employé");
        }
        //si l'employé est null
        if (employee == null) {
            //log aucun employé trouvé dans la base de données
            log.error("Aucun employé trouvé dans la base de données pour le matricule : " + matricule);
        }
        //log sortie de la méthode getEmployeeByMatricule du service EmployeeService
        log.info("Sortie de la méthode getEmployeeByMatricule du service EmployeeService");
        //retourner l'employé
        return employee;
    }

    //ajouter un employé
    public EmployeeDto addEmployee(EmployeeDto dto) {
        //log entrée dans la méthode addEmployee du service EmployeeService
        log.info("Entrée dans la méthode addEmployee du service EmployeeService");
        //try catch pour ajouter l'employé
        EmployeeDto employee = null;
        try {
            Employee e = mapper.map(dto, Employee.class);
            e.generateMatricule();
            e.setUsername(e.getEmail());
            e.setPassword(e.getPrenom().toLowerCase()+e.getNom().toLowerCase());
            Agence agence = agenceRepo.findById(UUID.fromString(dto.getAgenceId())).orElse(null);
            if (agence != null) {
                e.setAgence(agence);
            }

            //ajout de l'employé
            employee = mapper.map(employeeRepo.save(e), EmployeeDto.class);
            //log ajout de l'employé
            log.info("Ajout de l'employé");
        } catch (Exception e) {
            //log erreur ajout de l'employé
            log.error("Erreur lors de l'ajout de l'employé");
        }
        if (employee != null) {
            //log ajout de l'employé
            log.info("Employé {} ajouté avec succès", employee.getCni());
        }
        //log sortie de la méthode addEmployee du service EmployeeService
        log.info("Sortie de la méthode addEmployee du service EmployeeService");
        //retourner l'employé
        return employee;
    }

    //modifier un employé
    public EmployeeDto updateEmployee(EmployeeDto employee) {
        //log entrée dans la méthode updateEmployee du service EmployeeService
        log.info("Entrée dans la méthode updateEmployee du service EmployeeService");
        EmployeeDto employeeDto = null;
        //try catch pour modifier l'employé
        try {
            //modification de l'employé
            employeeDto = mapper.map(employeeRepo.save(mapper.map(employee, Employee.class)), EmployeeDto.class);
            //log modification de l'employé
            log.info("Modification de l'employé");
        } catch (Exception e) {
            //log erreur modification de l'employé
            log.error("Erreur lors de la modification de l'employé");
        }
        //log sortie de la méthode updateEmployee du service EmployeeService
        log.info("Sortie de la méthode updateEmployee du service EmployeeService");
        //retourner l'employé
        return employeeDto;
    }

    //affecter un employé à une agence
    public EmployeeDto affecterEmployeeToAgence(String employeeMatricule, String agenceId) {
        //log entrée dans la méthode affecterEmployeeToAgence du service EmployeeService
        log.info("Entrée dans la méthode affecterEmployeeToAgence du service EmployeeService");
        //initialisation de l'employé
        EmployeeDto e = null;
        //try catch pour affecter l'employé à une agence
        try {
            //récupération de l'employé
            Employee employee = employeeRepo.findByMatricule(employeeMatricule);
            //récuperation de l'agence
            Agence agence = agenceRepo.findById(UUID.fromString(agenceId)).orElse(null);
            if (agence != null) {
                //affectation de l'employé à une agence
                employee.setAgence(agence);
                //log affectation de l'employé à une agence
                log.info("Affectation de l'employé à une agence");
                e = mapper.map(employeeRepo.save(employee), EmployeeDto.class);
            }else {
                //log agence non trouvée
                log.error("Aucune agence trouvée pour l'id : {}", agenceId);
            }
        } catch (Exception ex) {
            //log erreur affectation de l'employé à une agence
            log.error("Erreur lors de l'affectation de l'employé à une agence : {}", ex.getMessage());
        }
        //log sortie de la méthode affecterEmployeeToAgence du service EmployeeService
        log.info("Sortie de la méthode affecterEmployeeToAgence du service EmployeeService");
        //retourner l'employé
        return e;
    }

    //supprimer un employé
    public void deleteEmployee(String matricule) {
        //log entrée dans la méthode deleteEmployee du service EmployeeService
        log.info("Entrée dans la méthode deleteEmployee du service EmployeeService");
        //try catch pour supprimer l'employé
        try {
            //suppression de l'employé
            employeeRepo.deleteByMatricule(matricule);
            //log suppression de l'employé
            log.info("Suppression de l'employé");
        } catch (Exception e) {
            //log erreur suppression de l'employé
            log.error("Erreur lors de la suppression de l'employé");
        }
        //log sortie de la méthode deleteEmployee du service EmployeeService
        log.info("Sortie de la méthode deleteEmployee du service EmployeeService");
    }

}