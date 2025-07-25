import { Injectable } from '@angular/core';
import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const token = sessionStorage.getItem('token');
    console.log('Token in interceptor:', token);
    if (token) {
      const cloned = req.clone({
        headers: req.headers.set('Authorization',token)
      });
      return next.handle(cloned);
    }
    return next.handle(req);
  }
}
