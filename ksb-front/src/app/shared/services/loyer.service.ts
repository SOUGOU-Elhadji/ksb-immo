import { MensualiteDto } from './../dts/mensualite-dto';
import { Loyer } from './../models/loyer';
import { HttpClient } from '@angular/common/http';
import { environment } from './../../../environments/environment';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoyerService {

  private _url = environment.apiLoyer;
  private _urlMensualite = environment.apiMensualite;

  constructor(private http: HttpClient) { }


  public getLoyers() {
    return this.http.get<Loyer[]>(this._url+'/paid');
  }

  public getLoyersNonPayes() {
    return this.http.get<Loyer[]>(this._url+'/unpaid');
  }

  public getLoyerByPropriete(id: string) {
    return this.http.get<Loyer[]>(this._url+'/propriete/'+id);
  }

  public enregistrerMensualite(mensualite: MensualiteDto){
    return this.http.post(this._urlMensualite, mensualite);
  }
}
