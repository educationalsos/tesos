import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Mission } from './mission';

@Injectable({
  providedIn: 'root'
})
export class MissionsService {
  public API = '//localhost:8080';
  public CONST_API = this.API + '/mission';

  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get(this.CONST_API + "/list");
  }

  get(id: number) {
    return this.http.get(this.CONST_API + '/' + id);
  }

  save(mission: Mission): Observable<any> {
    let result: Observable<Object>;
    result = this.http.post(this.CONST_API+ "/save", mission);
    return result;
  }

  update(mission: Mission){
    let result: Observable<Object>;
    result = this.http.post(this.CONST_API+ "/update/" + mission.id, mission);
    return result;
  }

  remove(id: number) {
    return this.http.delete(this.CONST_API + '/delete/' + id);
  }
}
