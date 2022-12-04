import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AgenceDto } from 'src/app/shared/dts/agence-dto';
import { Agence } from 'src/app/shared/models/agence';
import { Employee } from 'src/app/shared/models/employee';
import { AgenceService } from 'src/app/shared/services/agence.service';
import { EmployeeService } from 'src/app/shared/services/employee.service';


// export interface PeriodicElement {
//   name: string;
//   position: number;
//   weight: number;
//   symbol: string;
// }

const ELEMENT_DATA: Employee[] = [
  {id: '1', matricule: 'Hydrogen', nom: "malick", prenom: 'H', telephone: "778541256", email: "sougou@gmail.com", cni: "78451236", adresse: "thialy", numCompteBancaire: "1245214521452", manager: true, },
  
];

@Component({
  selector: 'app-create-agence',
  templateUrl: './create-agence.component.html',
  styleUrls: ['./create-agence.component.css']
})
export class CreateAgenceComponent implements OnInit {

  // agence: Agence = new Agence();
  agence: AgenceDto = new AgenceDto();
  agences!: Agence[];
  employeeList: Employee[] = [];

  public form!: FormGroup;
  disableSelect = new FormControl(false);

  displayedColumns: string[] = ['position', 'name', 'weight', 'symbol'];
  dataSource = ELEMENT_DATA;

  click = true;

  private isFormSubmitted!: boolean;
  private errorMessage!: string;
  public formErrors: { [key: string]: string } = {};

  hideData() {
    return (this.click = true);
  }

  constructor(private serviceAgence: AgenceService, private router: Router, 
    private serviceEmployee: EmployeeService, private fb: FormBuilder) { }

  ngOnInit(): void {
    this.serviceEmployee.getAllEmployee().subscribe((response) => {
      this.employeeList = response;
    });

    this.serviceAgence.getAllAgences().subscribe((response) => {
      this.agences = response;
    });

    this.form = this.fb.group({
      nom: ['', [Validators.required, Validators.maxLength(40)]],
      adresse: ['', [Validators.required, Validators.maxLength(40)]],
      region: ['', [Validators.required, Validators.maxLength(40)]],
      departement: ['', [Validators.required, Validators.maxLength(40)]],
      ville: ['', [Validators.required, Validators.maxLength(40)]],
      telephone: ['', [Validators.required, Validators.maxLength(40)]],
      dateCreation: ['', [Validators.required, Validators.maxLength(40)]],
      employees: new FormArray([])
   
    });

    
  }

  
  public saveAgence(): void {
    this.isFormSubmitted = true;
    this.form.updateValueAndValidity({
      onlySelf: true,
      emitEvent: true
    });

    if (this.form.valid) {
      if (this.form.dirty) {
        const agence: AgenceDto = {
          ...this.agence,
          ...this.form.value
        };

        // add or edit logic
        if (agence.id === 0) {
          this.serviceAgence.createTheAgence(agence).subscribe({
            next: () => this.saveCompleted(),
            error: (err) => this.errorMessage = err
          });
        } else {
          this.serviceAgence.updateTheAgence(agence).subscribe({
            next: () => this.saveCompleted(),
            error: (err) => this.errorMessage = err
          });
        }
      } else {
        this.saveCompleted();
      }
    } else {
      this.errorMessage = `Corrigez les erreurs svp.`;
    }
  }

  public saveCompleted(): void {
    this.form.reset();
    this.router.navigate(['/agences']);
  }

  public onSubmit() {
    try {
      this.serviceAgence.createAgence(this.agence).subscribe(data => {
        console.log(data);
        
      });
    } catch (error) {
      throw error;
    }
  }

  get employeeArray() {
    // return <FormArray>this.form.get('employees');
    return (<FormArray>this.form.get('employees'));
  
  }

  public addEmployee() {
    this.employeeArray.push(this.serviceEmployee.getEmployeeForm());
  }

  removeEmployee(i: number) {
    this.employeeArray.removeAt(i);
  }

  reload() {
    window.location.reload();
  }

}
