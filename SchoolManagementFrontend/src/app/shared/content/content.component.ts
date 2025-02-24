import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { NzContentComponent } from 'ng-zorro-antd/layout';

@Component({
  selector: 'app-content',
  standalone : true,
  imports: [NzContentComponent, RouterOutlet],
  templateUrl: './content.component.html',
  styleUrl: './content.component.css'
})
export class ContentComponent {

}
