import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { EmployeeDto } from 'src/app/shared/dts/employee-dto';
import { Agence } from 'src/app/shared/models/agence';
import { Employee } from 'src/app/shared/models/employee';
import { AgenceService } from 'src/app/shared/services/agence.service';
import { EmployeeService } from 'src/app/shared/services/employee.service';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {

  employee: EmployeeDto = new EmployeeDto();
  matricule!: string;
  agences: Agence[] = [];

  constructor(private service: EmployeeService, 
    private activedRoute: ActivatedRoute,
    private route: Router,
    private toastr : ToastrService,
    private agenceService: AgenceService) { }

  ngOnInit(): void {
    this.matricule = this.activedRoute.snapshot.params['matricule'];
    this.service.getEmployeeByMatricule(this.matricule).subscribe(data =>{
      this.employee = data;
    }, error => console.log(error));
    
    this.getAgences();

  }

  public getAgences() {
    this.agenceService.getAllAgences().subscribe((response) => {
      this.agences = response;
      console.log(response);
    })
  }

  updateEmployee(){
    return this.service.updateEmployee(this.employee).subscribe(data =>{
      this.route.navigate(['/employes']);
      console.log(data);
      this.showSuccess();
    }, error => {this.showError()});
  }

  private showSuccess() {
    this.toastr.success('Employer modifié avec succès',
    'Modification de l\'employer',
    {
      timeOut: 5000,
      positionClass: 'toast-bottom-right',
      progressBar: true,
      progressAnimation: 'increasing',
    });
  }

  private showError() {
    this.toastr.error('Une erreur est survenue lors du traitement de votre demande',
    'Erreur',
    {
      timeOut: 5000,
      positionClass: 'toast-bottom-right',
      progressBar: true,
      progressAnimation: 'increasing',
    });
  }

}
