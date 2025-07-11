import { LitElement, html, css } from 'lit';
import { customElement, property, state } from 'lit/decorators.js';

import '@vaadin/button';

@customElement('image-editor')
export class ImageEditor extends LitElement {
  @state()
  private zoom: number = 1;

  @state()
  private rotation: number = 0;

  private canvas!: HTMLCanvasElement;
  private ctx!: CanvasRenderingContext2D;
  private image!: HTMLImageElement;

  static get styles() {
    return css`
    	@import './image-editor.css';
    `;
  }
  render() {
    return html`
      <div class="editor-container">
        <canvas class="canvasEditor" width="400" height="300"></canvas>
        <div class="controls">
			<vaadin-button id="btnZoomIn">Zoom +</vaadin-button>
	        <vaadin-button id="btnZoomOut">Zoom -</vaadin-button>
	        <vaadin-button id="btnRotate">Rotate</vaadin-button>
	        <vaadin-button id="btnReset">Reset</vaadin-button>
        </div>
      </div>
    `;
  }

  firstUpdated() {
	
    this.canvas = this.renderRoot.querySelector('canvas.canvasEditor') as HTMLCanvasElement;
    this.ctx = this.canvas.getContext('2d')!;
	
    this.image = new Image();
    this.image.onload = () => this.draw();
	
    this.image.src = '/img/car.png'
	
  }

  private draw() {


	const { ctx, canvas, image, zoom, rotation } = this;

 	if (!ctx || !canvas || !image || !image.complete) {
    	console.warn("Canvas or image not ready");
    	return;
  	}

    ctx.save();
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    ctx.translate(canvas.width / 2, canvas.height / 2);
    ctx.rotate((rotation * Math.PI) / 180);
    ctx.scale(zoom, zoom);
    ctx.drawImage(image, -image.width / 2, -image.height / 2);
    ctx.restore();
  }

  private zoomIn() {
    this.zoom += 0.1;
    this.draw();
  }

  private zoomOut() {
    this.zoom = Math.max(0.1, this.zoom - 0.1);
    this.draw();
  }

  private rotate() {
    this.rotation = (this.rotation + 90) % 360;
    this.draw();
  }

  private reset() {
    this.zoom = 1;
    this.rotation = 0;
    this.draw();
	console.log("TTTTTTTTTTTT");
	(this as any).$server.showResetInfo();
  }
}
