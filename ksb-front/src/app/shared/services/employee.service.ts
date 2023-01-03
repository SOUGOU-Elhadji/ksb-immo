import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { EmployeeDto } from '../dts/employee-dto';
import { Employee } from '../models/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private Url = environment.apiEmployee;

  constructor(private fb: FormBuilder ,private httpClient: HttpClient) { }


  getEmployeeForm(){
    return this.fb.group({
      matricule: [''],
      nom: [' '],
      prenom: [' '],
      telephone: [' '],
      email: [' '],
      cni: [' '],
      dateDelivranceCni: [' '],
      adresse: [' '],
      numCompteBancaire: [' '],
      manager: [null, Validators.required],
      agence: [' ']
    });
  }



  //METHOD TO CREATE A NEW Employee
  public createEmployee(employee: EmployeeDto): Observable<Object>{
    const headers = { 'content-type': 'application/json'}  

    const params = new HttpParams()
      .set('para1', "value1")
      .set('para2',"value2");

    const body=JSON.stringify(employee);
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


  // METHOD TO GET ALL Employees
  public getAllEmployee(): Observable<Employee[]> {
    const params = new HttpParams()
      .set('sort',"description")
      .set('page',"2");
    const headers = new HttpHeaders()
      .set('Content-Type', 'application/json');
    return this.httpClient.get<Employee[]>(this.Url, {"params": params, 'headers': headers})
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

  // METHOD TO GET A Employee BY ID
  // public getEmployeeById(id: string): Observable<Employee>{
  //   const params = new HttpParams()
  //     .set('sort',"description")
  //     .set('page',"2");
  //   const headers = new HttpHeaders()
  //     .set('Content-Type', 'application/json');
  //   return this.httpClient.get<Employee>(`${this.Url}/${id}`, {"params": params, 'headers': headers})
  //   .pipe(
  //     map((response) => {
  //       return response;
  //     }),
  //     catchError((error) => {
  //       console.log('Error caught in service by getting id')
  //       console.error(error);
  //       throw error;
  //     })
  //   );
  // }

  // METHOD TO GET A Employee BY MATRICULE
  public getEmployeeByMatricule(matricule: string): Observable<EmployeeDto>{
    const params = new HttpParams()
      .set('sort',"description")
      .set('page',"2");
    const headers = new HttpHeaders()
      .set('Content-Type', 'application/json');
    return this.httpClient.get<EmployeeDto>(`${this.Url}/${matricule}`, {"params": params, 'headers': headers})
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

  // METHOD TO DELETE A Employee
  public deleteEmployee(matricule: string): Observable<Employee>{
    const params = new HttpParams()
      .set('sort',"description")
      .set('page',"2");
    const headers = new HttpHeaders()
      .set('Content-Type', 'application/json');
    return this.httpClient.delete<Employee>(`${this.Url}/${matricule}`, {"params": params, 'headers': headers})
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

  // METHOD TO UPDATE AN Employee
  public updateEmployee(employee: EmployeeDto): Observable<Object>{
    const params = new HttpParams()
      .set('sort', "description")
      .set('page', "2");
    const headers = new HttpHeaders()
      .set('Content-Type', 'application/json');
    return this.httpClient.put(`${this.Url}`, employee, {'params': params, 'headers': headers})
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

  public getEmployee(nom: String) {
    return this.httpClient.get<Employee[]>(`${this.Url}/page-query=${nom}&_limit=10`, 
    {observe: 'response'});
  }
  
}

