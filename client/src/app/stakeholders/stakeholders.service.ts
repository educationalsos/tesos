import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class StakeholdersService {
  public API = '//localhost:8080';
  public STAKE_API = this.API + '/stakeholder';

  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get(this.STAKE_API + "/list");
  }

  get(id: number) {
    return this.http.get(this.STAKE_API + '/' + id);
  }

  save(stake: any): Observable<any> {
    let result: Observable<Object>;
    if (stake['href']) {
      result = this.http.put(stake.href, stake);
    } else {
      console.log(JSON.stringify(stake))
      result = this.http.post(this.STAKE_API+ "/save", stake);
    }
    return result;
  }

  remove(id: number) {
    return this.http.delete(this.STAKE_API + '/delete/' + id);
  }
}
