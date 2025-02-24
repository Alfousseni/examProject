import {
  NzIconDirective,
  NzIconModule
} from "./chunk-JIVNQZ34.js";
import "./chunk-BQ76GOFF.js";
import "./chunk-2SJ2DHYL.js";
import {
  NzConfigService,
  WithConfig
} from "./chunk-PMLDN6SG.js";
import {
  PlatformModule
} from "./chunk-BPQFWBVU.js";
import "./chunk-KAFYJN3K.js";
import "./chunk-BL6M5BIS.js";
import "./chunk-ZFPA3UEG.js";
import "./chunk-S57O3SZI.js";
import {
  ChangeDetectionStrategy,
  ChangeDetectorRef,
  Component,
  ElementRef,
  EventEmitter,
  Input,
  NgModule,
  Output,
  ViewChild,
  ViewEncapsulation,
  afterRender,
  numberAttribute,
  setClassMetadata,
  ɵɵInputTransformsFeature,
  ɵɵNgOnChangesFeature,
  ɵɵadvance,
  ɵɵattribute,
  ɵɵclassProp,
  ɵɵconditional,
  ɵɵdefineComponent,
  ɵɵdefineInjector,
  ɵɵdefineNgModule,
  ɵɵdirectiveInject,
  ɵɵelement,
  ɵɵelementEnd,
  ɵɵelementStart,
  ɵɵgetCurrentView,
  ɵɵlistener,
  ɵɵloadQuery,
  ɵɵnextContext,
  ɵɵprojection,
  ɵɵprojectionDef,
  ɵɵproperty,
  ɵɵqueryRefresh,
  ɵɵresetView,
  ɵɵrestoreView,
  ɵɵsanitizeUrl,
  ɵɵstyleProp,
  ɵɵtemplate,
  ɵɵtext,
  ɵɵtextInterpolate,
  ɵɵviewQuery
} from "./chunk-KHWSNV4R.js";
import {
  __esDecorate,
  __runInitializers
} from "./chunk-6QNTARNC.js";
import "./chunk-WDMUDEB6.js";

// node_modules/ng-zorro-antd/fesm2022/ng-zorro-antd-avatar.mjs
var _c0 = ["textEl"];
function NzAvatarComponent_Conditional_0_Template(rf, ctx) {
  if (rf & 1) {
    ɵɵelement(0, "nz-icon", 1);
  }
  if (rf & 2) {
    const ctx_r0 = ɵɵnextContext();
    ɵɵproperty("nzType", ctx_r0.nzIcon);
  }
}
function NzAvatarComponent_Conditional_1_Template(rf, ctx) {
  if (rf & 1) {
    const _r2 = ɵɵgetCurrentView();
    ɵɵelementStart(0, "img", 4);
    ɵɵlistener("error", function NzAvatarComponent_Conditional_1_Template_img_error_0_listener($event) {
      ɵɵrestoreView(_r2);
      const ctx_r0 = ɵɵnextContext();
      return ɵɵresetView(ctx_r0.imgError($event));
    });
    ɵɵelementEnd();
  }
  if (rf & 2) {
    const ctx_r0 = ɵɵnextContext();
    ɵɵproperty("src", ctx_r0.nzSrc, ɵɵsanitizeUrl);
    ɵɵattribute("srcset", ctx_r0.nzSrcSet)("alt", ctx_r0.nzAlt);
  }
}
function NzAvatarComponent_Conditional_2_Template(rf, ctx) {
  if (rf & 1) {
    ɵɵelementStart(0, "span", 3, 0);
    ɵɵtext(2);
    ɵɵelementEnd();
  }
  if (rf & 2) {
    const ctx_r0 = ɵɵnextContext();
    ɵɵadvance(2);
    ɵɵtextInterpolate(ctx_r0.nzText);
  }
}
var _c1 = ["*"];
var NZ_CONFIG_MODULE_NAME = "avatar";
var NzAvatarComponent = (() => {
  let _nzShape_decorators;
  let _nzShape_initializers = [];
  let _nzShape_extraInitializers = [];
  let _nzSize_decorators;
  let _nzSize_initializers = [];
  let _nzSize_extraInitializers = [];
  let _nzGap_decorators;
  let _nzGap_initializers = [];
  let _nzGap_extraInitializers = [];
  return class NzAvatarComponent2 {
    static {
      const _metadata = typeof Symbol === "function" && Symbol.metadata ? /* @__PURE__ */ Object.create(null) : void 0;
      _nzShape_decorators = [WithConfig()];
      _nzSize_decorators = [WithConfig()];
      _nzGap_decorators = [WithConfig()];
      __esDecorate(null, null, _nzShape_decorators, {
        kind: "field",
        name: "nzShape",
        static: false,
        private: false,
        access: {
          has: (obj) => "nzShape" in obj,
          get: (obj) => obj.nzShape,
          set: (obj, value) => {
            obj.nzShape = value;
          }
        },
        metadata: _metadata
      }, _nzShape_initializers, _nzShape_extraInitializers);
      __esDecorate(null, null, _nzSize_decorators, {
        kind: "field",
        name: "nzSize",
        static: false,
        private: false,
        access: {
          has: (obj) => "nzSize" in obj,
          get: (obj) => obj.nzSize,
          set: (obj, value) => {
            obj.nzSize = value;
          }
        },
        metadata: _metadata
      }, _nzSize_initializers, _nzSize_extraInitializers);
      __esDecorate(null, null, _nzGap_decorators, {
        kind: "field",
        name: "nzGap",
        static: false,
        private: false,
        access: {
          has: (obj) => "nzGap" in obj,
          get: (obj) => obj.nzGap,
          set: (obj, value) => {
            obj.nzGap = value;
          }
        },
        metadata: _metadata
      }, _nzGap_initializers, _nzGap_extraInitializers);
      if (_metadata) Object.defineProperty(this, Symbol.metadata, {
        enumerable: true,
        configurable: true,
        writable: true,
        value: _metadata
      });
    }
    constructor(nzConfigService, elementRef, cdr) {
      this.nzConfigService = nzConfigService;
      this.elementRef = elementRef;
      this.cdr = cdr;
      this._nzModuleName = NZ_CONFIG_MODULE_NAME;
      this.nzShape = __runInitializers(this, _nzShape_initializers, "circle");
      this.nzSize = (__runInitializers(this, _nzShape_extraInitializers), __runInitializers(this, _nzSize_initializers, "default"));
      this.nzGap = (__runInitializers(this, _nzSize_extraInitializers), __runInitializers(this, _nzGap_initializers, 4));
      this.nzText = __runInitializers(this, _nzGap_extraInitializers);
      this.nzError = new EventEmitter();
      this.hasText = false;
      this.hasSrc = true;
      this.hasIcon = false;
      this.customSize = null;
      this.el = this.elementRef.nativeElement;
      afterRender(() => this.calcStringSize());
    }
    imgError($event) {
      this.nzError.emit($event);
      if (!$event.defaultPrevented) {
        this.hasSrc = false;
        this.hasIcon = false;
        this.hasText = false;
        if (this.nzIcon) {
          this.hasIcon = true;
        } else if (this.nzText) {
          this.hasText = true;
        }
        this.cdr.detectChanges();
        this.setSizeStyle();
        this.calcStringSize();
      }
    }
    ngOnChanges() {
      this.hasText = !this.nzSrc && !!this.nzText;
      this.hasIcon = !this.nzSrc && !!this.nzIcon;
      this.hasSrc = !!this.nzSrc;
      this.setSizeStyle();
      this.calcStringSize();
    }
    calcStringSize() {
      if (!this.hasText || !this.textEl) {
        return;
      }
      const textEl = this.textEl.nativeElement;
      const childrenWidth = textEl.offsetWidth;
      const avatarWidth = this.el.getBoundingClientRect?.().width ?? 0;
      const offset = this.nzGap * 2 < avatarWidth ? this.nzGap * 2 : 8;
      const scale = avatarWidth - offset < childrenWidth ? (avatarWidth - offset) / childrenWidth : 1;
      textEl.style.transform = `scale(${scale}) translateX(-50%)`;
      textEl.style.lineHeight = this.customSize || "";
    }
    setSizeStyle() {
      if (typeof this.nzSize === "number") {
        this.customSize = `${this.nzSize}px`;
      } else {
        this.customSize = null;
      }
      this.cdr.markForCheck();
    }
    static {
      this.ɵfac = function NzAvatarComponent_Factory(__ngFactoryType__) {
        return new (__ngFactoryType__ || NzAvatarComponent2)(ɵɵdirectiveInject(NzConfigService), ɵɵdirectiveInject(ElementRef), ɵɵdirectiveInject(ChangeDetectorRef));
      };
    }
    static {
      this.ɵcmp = ɵɵdefineComponent({
        type: NzAvatarComponent2,
        selectors: [["nz-avatar"]],
        viewQuery: function NzAvatarComponent_Query(rf, ctx) {
          if (rf & 1) {
            ɵɵviewQuery(_c0, 5);
          }
          if (rf & 2) {
            let _t;
            ɵɵqueryRefresh(_t = ɵɵloadQuery()) && (ctx.textEl = _t.first);
          }
        },
        hostAttrs: [1, "ant-avatar"],
        hostVars: 20,
        hostBindings: function NzAvatarComponent_HostBindings(rf, ctx) {
          if (rf & 2) {
            ɵɵstyleProp("width", ctx.customSize)("height", ctx.customSize)("line-height", ctx.customSize)("font-size", ctx.hasIcon && ctx.customSize ? ctx.nzSize / 2 : null, "px");
            ɵɵclassProp("ant-avatar-lg", ctx.nzSize === "large")("ant-avatar-sm", ctx.nzSize === "small")("ant-avatar-square", ctx.nzShape === "square")("ant-avatar-circle", ctx.nzShape === "circle")("ant-avatar-icon", ctx.nzIcon)("ant-avatar-image", ctx.hasSrc);
          }
        },
        inputs: {
          nzShape: "nzShape",
          nzSize: "nzSize",
          nzGap: [2, "nzGap", "nzGap", numberAttribute],
          nzText: "nzText",
          nzSrc: "nzSrc",
          nzSrcSet: "nzSrcSet",
          nzAlt: "nzAlt",
          nzIcon: "nzIcon"
        },
        outputs: {
          nzError: "nzError"
        },
        exportAs: ["nzAvatar"],
        features: [ɵɵInputTransformsFeature, ɵɵNgOnChangesFeature],
        decls: 3,
        vars: 1,
        consts: [["textEl", ""], [3, "nzType"], [3, "src"], [1, "ant-avatar-string"], [3, "error", "src"]],
        template: function NzAvatarComponent_Template(rf, ctx) {
          if (rf & 1) {
            ɵɵtemplate(0, NzAvatarComponent_Conditional_0_Template, 1, 1, "nz-icon", 1)(1, NzAvatarComponent_Conditional_1_Template, 1, 3, "img", 2)(2, NzAvatarComponent_Conditional_2_Template, 3, 1, "span", 3);
          }
          if (rf & 2) {
            ɵɵconditional(ctx.nzIcon && ctx.hasIcon ? 0 : ctx.nzSrc && ctx.hasSrc ? 1 : ctx.nzText && ctx.hasText ? 2 : -1);
          }
        },
        dependencies: [NzIconModule, NzIconDirective, PlatformModule],
        encapsulation: 2,
        changeDetection: 0
      });
    }
  };
})();
(() => {
  (typeof ngDevMode === "undefined" || ngDevMode) && setClassMetadata(NzAvatarComponent, [{
    type: Component,
    args: [{
      selector: "nz-avatar",
      exportAs: "nzAvatar",
      imports: [NzIconModule, PlatformModule],
      template: `
    @if (nzIcon && hasIcon) {
      <nz-icon [nzType]="nzIcon" />
    } @else if (nzSrc && hasSrc) {
      <img [src]="nzSrc" [attr.srcset]="nzSrcSet" [attr.alt]="nzAlt" (error)="imgError($event)" />
    } @else if (nzText && hasText) {
      <span class="ant-avatar-string" #textEl>{{ nzText }}</span>
    }
  `,
      host: {
        class: "ant-avatar",
        "[class.ant-avatar-lg]": `nzSize === 'large'`,
        "[class.ant-avatar-sm]": `nzSize === 'small'`,
        "[class.ant-avatar-square]": `nzShape === 'square'`,
        "[class.ant-avatar-circle]": `nzShape === 'circle'`,
        "[class.ant-avatar-icon]": `nzIcon`,
        "[class.ant-avatar-image]": `hasSrc `,
        "[style.width]": "customSize",
        "[style.height]": "customSize",
        "[style.line-height]": "customSize",
        // nzSize type is number when customSize is true
        "[style.font-size.px]": "(hasIcon && customSize) ? $any(nzSize) / 2 : null"
      },
      preserveWhitespaces: false,
      changeDetection: ChangeDetectionStrategy.OnPush,
      encapsulation: ViewEncapsulation.None
    }]
  }], () => [{
    type: NzConfigService
  }, {
    type: ElementRef
  }, {
    type: ChangeDetectorRef
  }], {
    nzShape: [{
      type: Input
    }],
    nzSize: [{
      type: Input
    }],
    nzGap: [{
      type: Input,
      args: [{
        transform: numberAttribute
      }]
    }],
    nzText: [{
      type: Input
    }],
    nzSrc: [{
      type: Input
    }],
    nzSrcSet: [{
      type: Input
    }],
    nzAlt: [{
      type: Input
    }],
    nzIcon: [{
      type: Input
    }],
    nzError: [{
      type: Output
    }],
    textEl: [{
      type: ViewChild,
      args: ["textEl", {
        static: false
      }]
    }]
  });
})();
var NzAvatarGroupComponent = class _NzAvatarGroupComponent {
  static {
    this.ɵfac = function NzAvatarGroupComponent_Factory(__ngFactoryType__) {
      return new (__ngFactoryType__ || _NzAvatarGroupComponent)();
    };
  }
  static {
    this.ɵcmp = ɵɵdefineComponent({
      type: _NzAvatarGroupComponent,
      selectors: [["nz-avatar-group"]],
      hostAttrs: [1, "ant-avatar-group"],
      exportAs: ["nzAvatarGroup"],
      ngContentSelectors: _c1,
      decls: 1,
      vars: 0,
      template: function NzAvatarGroupComponent_Template(rf, ctx) {
        if (rf & 1) {
          ɵɵprojectionDef();
          ɵɵprojection(0);
        }
      },
      encapsulation: 2,
      changeDetection: 0
    });
  }
};
(() => {
  (typeof ngDevMode === "undefined" || ngDevMode) && setClassMetadata(NzAvatarGroupComponent, [{
    type: Component,
    args: [{
      selector: "nz-avatar-group",
      exportAs: "nzAvatarGroup",
      template: `<ng-content></ng-content>`,
      changeDetection: ChangeDetectionStrategy.OnPush,
      host: {
        class: "ant-avatar-group"
      }
    }]
  }], null, null);
})();
var NzAvatarModule = class _NzAvatarModule {
  static {
    this.ɵfac = function NzAvatarModule_Factory(__ngFactoryType__) {
      return new (__ngFactoryType__ || _NzAvatarModule)();
    };
  }
  static {
    this.ɵmod = ɵɵdefineNgModule({
      type: _NzAvatarModule,
      imports: [NzAvatarComponent, NzAvatarGroupComponent],
      exports: [NzAvatarComponent, NzAvatarGroupComponent]
    });
  }
  static {
    this.ɵinj = ɵɵdefineInjector({
      imports: [NzAvatarComponent]
    });
  }
};
(() => {
  (typeof ngDevMode === "undefined" || ngDevMode) && setClassMetadata(NzAvatarModule, [{
    type: NgModule,
    args: [{
      exports: [NzAvatarComponent, NzAvatarGroupComponent],
      imports: [NzAvatarComponent, NzAvatarGroupComponent]
    }]
  }], null, null);
})();
export {
  NzAvatarComponent,
  NzAvatarGroupComponent,
  NzAvatarModule
};
//# sourceMappingURL=ng-zorro-antd_avatar.js.map
