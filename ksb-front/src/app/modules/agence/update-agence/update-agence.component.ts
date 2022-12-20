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

  private isFormSubmitted!: boolean;
  private errorMessage!: string;
  public formErrors: { [key: string]: string } = {};

  constructor(private serviceAgence: AgenceService,
    private fb: FormBuilder, private route: ActivatedRoute,
      private router: Router) { }

  ngOnInit(): void {
    
  }



updateAgence(){
  return this.serviceAgence.updateAgence(this.agence).subscribe(data =>{
    this.router.navigate(['/agence'])
    console.log(data);
  }, error => console.log(error));
}






}
