import { MensualiteDto } from './../../../shared/dts/mensualite-dto';
import { Loyer } from 'src/app/shared/models/loyer';
import { Component, OnInit } from '@angular/core';
import { LoyerService } from 'src/app/shared/services/loyer.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-loyer-non-payes',
  templateUrl: './loyer-non-payes.component.html',
  styleUrls: ['./loyer-non-payes.component.css']
})
export class LoyerNonPayesComponent implements OnInit {

  loyers: Loyer[] = [];
  nombreDeMois !: number ;
  mensualiteDto !: MensualiteDto;
  p: number = 1;

  constructor(private service: LoyerService, private toastr: ToastrService) { }

  ngOnInit(): void {
    this.getLoyersNonPayes();
  }

  public payer(loyer: Loyer){
    this.mensualiteDto = new MensualiteDto();
    this.mensualiteDto.loyerId = loyer.id;
    this.mensualiteDto.montant = loyer.mensualite;
    this.mensualiteDto.nombreMois = this.nombreDeMois;
    this.service.enregistrerMensualite(this.mensualiteDto).subscribe(
      data => {
        if (data.hasOwnProperty('id') && JSON.stringify(data).indexOf('id') != null) {
          this.showNotification();
          this.getLoyersNonPayes();
        }
      }
    )
  }

  public getLoyersNonPayes() {
    this.service.getLoyersNonPayes().subscribe(
      data => {
        this.loyers = data
        console.log(this.loyers);
      }
    )
  }

  public showNotification(){
    this.toastr.success("Paiement effectué avec succès", "Succès", {
      timeOut: 5000,
      progressBar: true,
      progressAnimation: 'decreasing',
      positionClass: 'toast-bottom-right'
    });
  }
}
