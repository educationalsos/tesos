import { Routes } from '@angular/router';

import { DashboardComponent } from '../../dashboard/dashboard.component';
import { TableListComponent } from '../../table-list/table-list.component';
import { TypographyComponent } from '../../typography/typography.component';
import { IconsComponent } from '../../icons/icons.component';
import { MapsComponent } from '../../maps/maps.component';
import { NotificationsComponent } from '../../notifications/notifications.component';
import { HomeComponent } from '../../home/home.component';
import { SosComponent } from 'app/sos/sos.component';
import { NewSoSComponent } from 'app/new-so-s/new-so-s.component';
import { SosListComponent } from 'app/sos-list/sos-list.component';

export const AdminLayoutRoutes: Routes = [
    {path: '',         component: HomeComponent},
    { path: 'sos/:id',            component: SosComponent},
    { path: 'add',         component: NewSoSComponent},
];
