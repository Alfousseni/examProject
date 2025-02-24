import { Component } from '@angular/core';
import { NzLayoutModule } from 'ng-zorro-antd/layout';
import { SidebarComponent } from "../shared/sidebar/sidebar.component";
import { HeaderComponent } from "../shared/header/header.component";
import { ContentComponent } from "../shared/content/content.component";

@Component({
  selector: 'app-layout',
  imports: [NzLayoutModule, SidebarComponent, HeaderComponent, ContentComponent],
  templateUrl: './layout.component.html',
  styleUrl: './layout.component.css'
})
export class LayoutComponent {
  isCollapsed = false;
}
