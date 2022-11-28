import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

import {catchError, map} from 'rxjs/operators';
import { Proprietaire } from '../models/proprietaire';


// const httpOptions = {
//   headers: new HttpHeaders({
//     'Content-Type': 'application/json',
//     'Access-Control-Allow-Origin': '*',
//   }),
// };


@Injectable({
  providedIn: 'root'
})
export class ProprietaireService {

  private Url = environment.apiProprietaire;

  constructor(private httpClient: HttpClient) { }

  // METHOD TO CREATE A NEW Proprietaire
  public createProprietaire(proprietaire: Proprietaire): Observable<Object>{
    const headers = { 'content-type': 'application/json'}  

    const params = new HttpParams()
      .set('para1', "value1")
      .set('para2',"value2");

    const body=JSON.stringify(Proprietaire);
    console.log(body)
    return this.httpClient.post(this.Url, body, {'headers':headers, observe:'response', 
      reportProgress: true, 'params': params})
      .pipe(
        catchError((err) => {
          console.error(err);
          throw err;
        })
      );
  }

  // METHOD TO GET ALL Proprietaires
  public getAllProprietaires(): Observable<Proprietaire[]> {
    const params = new HttpParams()
      .set('sort',"description")
      .set('page',"2");
    const headers = new HttpHeaders()
      .set('Content-Type', 'application/json');
    return this.httpClient.get<Proprietaire[]>(this.Url, {"params": params, 'headers': headers})
    // return this.httpClient.get<Agence[]>(`${this.Url}`, {'params': params})
    .pipe(
      map((response) => {
        return response;
      }),
      catchError((err, caught) => {
        console.log('error caught in service', err)
          console.error(err);
          // return throwError(err);   
          throw err;
      })
    );
  }

  // METHOD TO GET A Proprietaire BY ID
  public getProprietaireById(id: string): Observable<Proprietaire>{
    const params = new HttpParams()
      .set('sort',"description")
      .set('page',"2");
    const headers = new HttpHeaders()
      .set('Content-Type', 'application/json');
    return this.httpClient.get<Proprietaire>(`${this.Url}/${id}`, {"params": params, 'headers': headers})
    .pipe(
      map((response) => {
        return response;
      }),
      catchError((error) => {
        console.log('Error caught in service by getting id')
        console.error(error);
        throw error;
      })
    );
  }

  // METHOD TO DELETE A Proprietaire
  public deleteProprietaire(id: string): Observable<Object>{
    const params = new HttpParams()
      .set('sort',"description")
      .set('page',"2");
    const headers = new HttpHeaders()
      .set('Content-Type', 'application/json');
    return this.httpClient.delete<Proprietaire>(`${this.Url}/${id}`, {"params": params, 'headers': headers})
      .pipe(
        map((response) => {
          return response;
        }),
        catchError((error) => {
          console.log('Error caught in service by deleting an object');
          console.error(error);
          throw error;
        })
      );
  }

  // METHOD TO UPDATE A Proprietaire
  public updateProprietaire(id: string, proprietaire: Proprietaire): Observable<Object>{
    const params = new HttpParams()
      .set('sort', "description")
      .set('page', "2");
    const headers = new HttpHeaders()
      .set('Content-Type', 'application/json');
    return this.httpClient.put<Proprietaire>(`${this.Url}/${id}`, proprietaire, {'params': params, 'headers': headers})
      .pipe(
        map((response) => {
          return response;
        }),
        catchError((error) => {
          console.log('Error caught in service');
          console.error(error);
          throw error;
        })
      );
  }

  public getProprietaire(nom: String) {
    return this.httpClient.get<Proprietaire[]>(`${this.Url}/page-query=${nom}&_limit=10`, 
    {observe: 'response'});
  }
  
}
