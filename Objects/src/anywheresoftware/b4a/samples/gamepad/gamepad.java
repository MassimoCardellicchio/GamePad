package anywheresoftware.b4a.samples.gamepad;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class gamepad extends B4AClass.ImplB4AClass{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "anywheresoftware.b4a.samples.gamepad.gamepad");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
        }
        _class_globals();
    }


 public static class _joystick{
boolean IsInitialized;
float x;
float y;
float zeroX;
float zeroY;
int color;
public void Initialize() {
IsInitialized = true;
x = 0f;
y = 0f;
zeroX = 0f;
zeroY = 0f;
color = 0;
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.agraham.gestures.Gestures _ges = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper _cvs = null;
public gamepad._joystick _joy = null;
public int _radius = 0;
public int _r_max = 0;
public float _r_curr = 0f;
public float _dx = 0f;
public float _dy = 0f;
public main _main = null;
public String  _addtoactivity(anywheresoftware.b4a.objects.ActivityWrapper _act,int _vleft,int _vtop,int _vwidth,int _vheight) throws Exception{
anywheresoftware.b4a.objects.ImageViewWrapper _iv1 = null;
 //BA.debugLineNum = 23;BA.debugLine="Public Sub AddToActivity(act As Activity, vLeft As Int, vTop As Int, vWidth As Int, vHeight As Int)";
 //BA.debugLineNum = 24;BA.debugLine="Dim iv1 As ImageView";
_iv1 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 25;BA.debugLine="iv1.Initialize(\"\")";
_iv1.Initialize(ba,"");
 //BA.debugLineNum = 26;BA.debugLine="iv1.Bitmap = LoadBitmap(File.DirAssets, \"ffjoy.png\")";
_iv1.setBitmap((android.graphics.Bitmap)(__c.LoadBitmap(__c.File.getDirAssets(),"ffjoy.png").getObject()));
 //BA.debugLineNum = 27;BA.debugLine="iv1.Gravity = Gravity.FILL";
_iv1.setGravity(__c.Gravity.FILL);
 //BA.debugLineNum = 28;BA.debugLine="act.AddView(iv1, vLeft, vTop, vWidth, vHeight)";
_act.AddView((android.view.View)(_iv1.getObject()),_vleft,_vtop,_vwidth,_vheight);
 //BA.debugLineNum = 29;BA.debugLine="act.AddView(pnl, vLeft, vTop, vWidth, vHeight)";
_act.AddView((android.view.View)(_pnl.getObject()),_vleft,_vtop,_vwidth,_vheight);
 //BA.debugLineNum = 30;BA.debugLine="cvs.Initialize(pnl)";
_cvs.Initialize((android.view.View)(_pnl.getObject()));
 //BA.debugLineNum = 31;BA.debugLine="joy.zeroX = pnl.Height / 2";
_joy.zeroX = (float)(_pnl.getHeight()/(double)2);
 //BA.debugLineNum = 32;BA.debugLine="joy.zeroY = pnl.Height / 2";
_joy.zeroY = (float)(_pnl.getHeight()/(double)2);
 //BA.debugLineNum = 33;BA.debugLine="MoveJoystick(joy.zeroX, joy.zeroY, joy)";
_movejoystick(_joy.zeroX,_joy.zeroY,_joy);
 //BA.debugLineNum = 34;BA.debugLine="pnl.Invalidate";
_pnl.Invalidate();
 //BA.debugLineNum = 35;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Private ges As Gestures";
_ges = new anywheresoftware.b4a.agraham.gestures.Gestures();
 //BA.debugLineNum = 4;BA.debugLine="Private pnl As Panel";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 5;BA.debugLine="Private cvs As Canvas";
_cvs = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
 //BA.debugLineNum = 6;BA.debugLine="Type joystick(x As Float, y As Float, zeroX As Float, zeroY As Float, color As Int)";
;
 //BA.debugLineNum = 7;BA.debugLine="Dim joy As joystick";
_joy = new gamepad._joystick();
 //BA.debugLineNum = 8;BA.debugLine="Private radius As Int: radius = 50dip 'radius of the stick";
_radius = 0;
 //BA.debugLineNum = 8;BA.debugLine="Private radius As Int: radius = 50dip 'radius of the stick";
_radius = __c.DipToCurrent((int)(50));
 //BA.debugLineNum = 9;BA.debugLine="Dim r_max As Int: r_max = 35dip 'max distance between the center of the stick and the center of the pad";
_r_max = 0;
 //BA.debugLineNum = 9;BA.debugLine="Dim r_max As Int: r_max = 35dip 'max distance between the center of the stick and the center of the pad";
_r_max = __c.DipToCurrent((int)(35));
 //BA.debugLineNum = 10;BA.debugLine="Dim r_curr As Float: r_curr = 0 'current distance between the center of the stick and the center of the pad";
_r_curr = 0f;
 //BA.debugLineNum = 10;BA.debugLine="Dim r_curr As Float: r_curr = 0 'current distance between the center of the stick and the center of the pad";
_r_curr = (float)(0);
 //BA.debugLineNum = 11;BA.debugLine="Dim Dx As Float: Dx = 0";
_dx = 0f;
 //BA.debugLineNum = 11;BA.debugLine="Dim Dx As Float: Dx = 0";
_dx = (float)(0);
 //BA.debugLineNum = 12;BA.debugLine="Dim Dy As Float: Dy = 0";
_dy = 0f;
 //BA.debugLineNum = 12;BA.debugLine="Dim Dy As Float: Dy = 0";
_dy = (float)(0);
 //BA.debugLineNum = 13;BA.debugLine="End Sub";
return "";
}
public float  _computeangle(float _x,float _y) throws Exception{
 //BA.debugLineNum = 76;BA.debugLine="Private Sub ComputeAngle(x As Float, y As Float) As Float";
 //BA.debugLineNum = 77;BA.debugLine="If x > 0 AND y >= 0 Then";
if (_x>0 && _y>=0) { 
 //BA.debugLineNum = 78;BA.debugLine="Return ATan(y/x)";
if (true) return (float)(__c.ATan(_y/(double)_x));
 }else if(_x>0 && _y<0) { 
 //BA.debugLineNum = 80;BA.debugLine="Return ATan(y/x) + 2*cPI";
if (true) return (float)(__c.ATan(_y/(double)_x)+2*__c.cPI);
 }else if(_x<0) { 
 //BA.debugLineNum = 82;BA.debugLine="Return ATan(y/x) + cPI";
if (true) return (float)(__c.ATan(_y/(double)_x)+__c.cPI);
 }else if(_x==0 && _y>0) { 
 //BA.debugLineNum = 84;BA.debugLine="Return cPI/2";
if (true) return (float)(__c.cPI/(double)2);
 }else if(_x==0 && _y<0) { 
 //BA.debugLineNum = 86;BA.debugLine="Return 3*cPI/2";
if (true) return (float)(3*__c.cPI/(double)2);
 }else {
 //BA.debugLineNum = 88;BA.debugLine="Return 0";
if (true) return (float)(0);
 };
 //BA.debugLineNum = 90;BA.debugLine="End Sub";
return 0f;
}
public float  _computedist(float _x,float _y,gamepad._joystick _j) throws Exception{
 //BA.debugLineNum = 72;BA.debugLine="Private Sub ComputeDist(x As Float, y As Float, j As joystick) As Float";
 //BA.debugLineNum = 73;BA.debugLine="Return Sqrt(Power(x - j.zeroX, 2)+Power(y - j.zeroY, 2))";
if (true) return (float)(__c.Sqrt(__c.Power(_x-_j.zeroX,2)+__c.Power(_y-_j.zeroY,2)));
 //BA.debugLineNum = 74;BA.debugLine="End Sub";
return 0f;
}
public float[]  _getjoyvalue() throws Exception{
float[] _v = null;
 //BA.debugLineNum = 91;BA.debugLine="Public Sub GetJoyValue As Float()";
 //BA.debugLineNum = 92;BA.debugLine="Dim v(2) As Float";
_v = new float[(int)(2)];
;
 //BA.debugLineNum = 93;BA.debugLine="Dim r_curr As Float: r_curr = ComputeDist(joy.x,joy.y,joy)";
_r_curr = 0f;
 //BA.debugLineNum = 93;BA.debugLine="Dim r_curr As Float: r_curr = ComputeDist(joy.x,joy.y,joy)";
_r_curr = _computedist(_joy.x,_joy.y,_joy);
 //BA.debugLineNum = 94;BA.debugLine="v(0) = r_curr/r_max 'normalized linear velocity [m/s]";
_v[(int)(0)] = (float)(_r_curr/(double)_r_max);
 //BA.debugLineNum = 95;BA.debugLine="v(1) = ATan2(Dx,Dy) 'angular vel [rad/s]";
_v[(int)(1)] = (float)(__c.ATan2(_dx,_dy));
 //BA.debugLineNum = 96;BA.debugLine="Return v";
if (true) return _v;
 //BA.debugLineNum = 97;BA.debugLine="End Sub";
return null;
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 15;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 16;BA.debugLine="pnl.Initialize(\"\")";
_pnl.Initialize(ba,"");
 //BA.debugLineNum = 17;BA.debugLine="ges.SetOnTouchListener(pnl, \"pnl_multitouch\")";
_ges.SetOnTouchListener(ba,(android.view.View)(_pnl.getObject()),"pnl_multitouch");
 //BA.debugLineNum = 18;BA.debugLine="joy.Initialize";
_joy.Initialize();
 //BA.debugLineNum = 19;BA.debugLine="joy.color = Colors.ARGB(115, 112, 112, 100)";
_joy.color = __c.Colors.ARGB((int)(115),(int)(112),(int)(112),(int)(100));
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return "";
}
public String  _movejoystick(float _x,float _y,gamepad._joystick _j) throws Exception{
float _r = 0f;
float _angle = 0f;
 //BA.debugLineNum = 56;BA.debugLine="Private Sub MoveJoystick(x As Float, y As Float, j As joystick)";
 //BA.debugLineNum = 57;BA.debugLine="cvs.DrawCircle(j.x, j.y, radius, Colors.Transparent, True, 0) 'delete previous track";
_cvs.DrawCircle(_j.x,_j.y,(float)(_radius),__c.Colors.Transparent,__c.True,(float)(0));
 //BA.debugLineNum = 58;BA.debugLine="Dx = x - j.zeroX";
_dx = (float)(_x-_j.zeroX);
 //BA.debugLineNum = 59;BA.debugLine="Dy = j.zeroY - y";
_dy = (float)(_j.zeroY-_y);
 //BA.debugLineNum = 60;BA.debugLine="Dim r As Float: r = ComputeDist(x,y,j)";
_r = 0f;
 //BA.debugLineNum = 60;BA.debugLine="Dim r As Float: r = ComputeDist(x,y,j)";
_r = _computedist(_x,_y,_j);
 //BA.debugLineNum = 61;BA.debugLine="Dim angle As Float: angle = ComputeAngle(Dx,Dy)";
_angle = 0f;
 //BA.debugLineNum = 61;BA.debugLine="Dim angle As Float: angle = ComputeAngle(Dx,Dy)";
_angle = _computeangle(_dx,_dy);
 //BA.debugLineNum = 62;BA.debugLine="If r < r_max Then";
if (_r<_r_max) { 
 //BA.debugLineNum = 63;BA.debugLine="j.x = x";
_j.x = _x;
 //BA.debugLineNum = 64;BA.debugLine="j.y = y";
_j.y = _y;
 }else {
 //BA.debugLineNum = 66;BA.debugLine="j.x = r_max*Cos(angle)+j.zeroX";
_j.x = (float)(_r_max*__c.Cos(_angle)+_j.zeroX);
 //BA.debugLineNum = 67;BA.debugLine="j.y = -r_max*Sin(angle)+j.zeroY";
_j.y = (float)(-_r_max*__c.Sin(_angle)+_j.zeroY);
 };
 //BA.debugLineNum = 69;BA.debugLine="cvs.DrawCircle(j.x, j.y, radius, j.color, True, 0)";
_cvs.DrawCircle(_j.x,_j.y,(float)(_radius),_j.color,__c.True,(float)(0));
 //BA.debugLineNum = 70;BA.debugLine="End Sub";
return "";
}
public boolean  _pnl_multitouch(Object _view,int _pointerid,int _action,float _x,float _y) throws Exception{
boolean _foundjoy = false;
int _i = 0;
float _gx = 0f;
float _gy = 0f;
 //BA.debugLineNum = 37;BA.debugLine="Private Sub pnl_multitouch(View As Object, pointerID As Int, action As Int, x As Float, Y As Float) As Boolean";
 //BA.debugLineNum = 38;BA.debugLine="Dim foundJoy As Boolean";
_foundjoy = false;
 //BA.debugLineNum = 39;BA.debugLine="For i = 0 To ges.GetPointerCount - 1";
{
final double step38 = 1;
final double limit38 = (int)(_ges.GetPointerCount()-1);
for (_i = (int)(0); (step38 > 0 && _i <= limit38) || (step38 < 0 && _i >= limit38); _i += step38) {
 //BA.debugLineNum = 40;BA.debugLine="If (action = ges.ACTION_UP OR action = ges.ACTION_POINTER_UP OR action = ges.ACTION_DOWN) AND _ 			ges.GetPointerID(i) = pointerID Then";
if ((_action==_ges.ACTION_UP || _action==_ges.ACTION_POINTER_UP || _action==_ges.ACTION_DOWN) && _ges.GetPointerID(_i)==_pointerid) { 
 //BA.debugLineNum = 42;BA.debugLine="Continue";
if (true) continue;
 };
 //BA.debugLineNum = 44;BA.debugLine="If ges.GetX(i) = -1 AND ges.GetY(i) = -1 Then Continue";
if (_ges.GetX(_i)==-1 && _ges.GetY(_i)==-1) { 
if (true) continue;};
 //BA.debugLineNum = 45;BA.debugLine="Dim gx, gy As Float";
_gx = 0f;
_gy = 0f;
 //BA.debugLineNum = 46;BA.debugLine="gx = Max(0, Min(ges.GetX(i), pnl.Width))";
_gx = (float)(__c.Max(0,__c.Min(_ges.GetX(_i),_pnl.getWidth())));
 //BA.debugLineNum = 47;BA.debugLine="gy = Max(0, Min(ges.GetY(i), pnl.Height))";
_gy = (float)(__c.Max(0,__c.Min(_ges.GetY(_i),_pnl.getHeight())));
 //BA.debugLineNum = 48;BA.debugLine="foundJoy = True";
_foundjoy = __c.True;
 //BA.debugLineNum = 49;BA.debugLine="MoveJoystick(gx, gy, joy)";
_movejoystick(_gx,_gy,_joy);
 }
};
 //BA.debugLineNum = 51;BA.debugLine="If Not(foundJoy) Then MoveJoystick(joy.zeroX, joy.zeroY, joy)";
if (__c.Not(_foundjoy)) { 
_movejoystick(_joy.zeroX,_joy.zeroY,_joy);};
 //BA.debugLineNum = 52;BA.debugLine="pnl.Invalidate";
_pnl.Invalidate();
 //BA.debugLineNum = 53;BA.debugLine="Return True";
if (true) return __c.True;
 //BA.debugLineNum = 54;BA.debugLine="End Sub";
return false;
}
}
