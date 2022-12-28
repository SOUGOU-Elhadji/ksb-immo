import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AgenceDto } from 'src/app/shared/dts/agence-dto';
import { AgenceService } from 'src/app/shared/services/agence.service';

@Component({
  selector: 'app-update-agence',
  templateUrl: './update-agence.component.html',
  styleUrls: ['./update-agence.component.css']
})
export class UpdateAgenceComponent implements OnInit {

  agence: AgenceDto = new AgenceDto();
  id!: string;

  public form!: FormGroup;
  disableSelect = new FormControl(false);

  public formErrors: { [key: string]: string } = {};

  constructor(private serviceAgence: AgenceService,
    private fb: FormBuilder, private route: ActivatedRoute,
      private router: Router,) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.serviceAgence.getAgenceById(this.id).subscribe(data =>{
      this.agence = data;
    }, error => console.log(error));

    this.form = this.fb.group({
      nom: ['', [Validators.required, Validators.maxLength(40)]],
      adresse: ['', [Validators.required, Validators.maxLength(40)]],
      region: ['', [Validators.required, Validators.maxLength(40)]],
      departement: ['', [Validators.required, Validators.maxLength(40)]],
      telephone: ['', [Validators.required, Validators.maxLength(40)]],
      // employees: new FormArray([])
  
    });
  

  }

  


updateAgence(){
  return this.serviceAgence.updateAgence(this.agence).subscribe(data =>{
    this.router.navigate(['/agences'])
    console.log(data);
  }, error => console.log(error));
}






}
