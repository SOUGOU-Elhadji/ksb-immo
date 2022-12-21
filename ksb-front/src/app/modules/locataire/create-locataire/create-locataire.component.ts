import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Locataire } from 'src/app/shared/models/locataire';
import { LocataireService } from 'src/app/shared/services/locataire.service';

@Component({
  selector: 'app-create-locataire',
  templateUrl: './create-locataire.component.html',
  styleUrls: ['./create-locataire.component.css']
})
export class CreateLocataireComponent implements OnInit {

  locataires: Locataire = new Locataire();

locatair: Locataire[]=[];

@Input() inputFormGroup = this.fb.group({});


  constructor(private fb: FormBuilder, private locataireService: LocataireService) { }

  ngOnInit(): void {
  }
  public onSubmit(){
    try{
      this.locataireService.createLocataire(this.locataires).subscribe((data: any) => {
        console.log(data);
        console.log("created");
        // window.location.reload();
      });
    }catch(error){
      throw error;
    }
  }
}
