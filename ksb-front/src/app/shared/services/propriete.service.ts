import { ProprieteDto } from './../dts/propriete-dto';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProprieteService {

  private _url = environment.apiPropriete;

  constructor(private http: HttpClient) { }

  public ajouterProprieteAuProprietaire(propriete: ProprieteDto) {
    return this.http.post(this._url, propriete);
  }
}
