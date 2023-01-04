import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AgenceDto } from 'src/app/shared/dts/agence-dto';
import { Agence } from 'src/app/shared/models/agence';
import { Employee } from 'src/app/shared/models/employee';
import { AgenceService } from 'src/app/shared/services/agence.service';

@Component({
  selector: 'app-details-agence',
  templateUrl: './details-agence.component.html',
  styleUrls: ['./details-agence.component.css']
})
export class DetailsAgenceComponent implements OnInit {

  agence: AgenceDto = new AgenceDto();
  id!: string;
  date: Date = new Date();
  p: number = 1;

  constructor(private service: AgenceService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.service.getAgenceById(this.id).subscribe(data => {
      this.agence = data;
    })
  }

  agenceEdit(id: string){
    this.router.navigate(['/employes', id, 'edit']);
  }

}
