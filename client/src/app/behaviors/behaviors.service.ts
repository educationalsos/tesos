import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Behavior } from './behavior';

@Injectable({
  providedIn: 'root'
})
export class BehaviorsService {
  public API = '//localhost:8080';
  public CONST_API = this.API + '/behavior';

  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get(this.CONST_API + "/list");
  }

  get(id: number) {
    return this.http.get(this.CONST_API + '/' + id);
  }

  save(behavior: Behavior): Observable<any> {
    let result: Observable<Object>;
    result = this.http.post(this.CONST_API+ "/save", behavior);
    return result;
  }

  update(behavior: Behavior){
    let result: Observable<Object>;
    result = this.http.post(this.CONST_API+ "/update/" + behavior.id, behavior);
    return result;
  }

  remove(id: number) {
    return this.http.delete(this.CONST_API + '/delete/' + id);
  }
}
