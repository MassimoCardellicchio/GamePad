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
anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper DestRect;
float x;
float y;
float zeroX;
float zeroY;
int color;
public void Initialize() {
IsInitialized = true;
DestRect = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper();
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
public main _main = null;
public String  _addtoactivity(anywheresoftware.b4a.objects.ActivityWrapper _act,int _vleft,int _vtop,int _vwidth,int _vheight) throws Exception{
anywheresoftware.b4a.objects.ImageViewWrapper _iv1 = null;
 //BA.debugLineNum = 27;BA.debugLine="Public Sub AddToActivity(act As Activity, vLeft As Int, vTop As Int, vWidth As Int, vHeight As Int)";
 //BA.debugLineNum = 28;BA.debugLine="Dim iv1 As ImageView";
_iv1 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 29;BA.debugLine="iv1.Initialize(\"\")";
_iv1.Initialize(ba,"");
 //BA.debugLineNum = 30;BA.debugLine="iv1.Bitmap = LoadBitmap(File.DirAssets, \"ffjoy.png\")";
_iv1.setBitmap((android.graphics.Bitmap)(__c.LoadBitmap(__c.File.getDirAssets(),"ffjoy.png").getObject()));
 //BA.debugLineNum = 31;BA.debugLine="iv1.Gravity = Gravity.FILL";
_iv1.setGravity(__c.Gravity.FILL);
 //BA.debugLineNum = 32;BA.debugLine="act.AddView(iv1, vLeft, vTop, vHeight, vHeight)";
_act.AddView((android.view.View)(_iv1.getObject()),_vleft,_vtop,_vheight,_vheight);
 //BA.debugLineNum = 40;BA.debugLine="act.AddView(pnl, vLeft, vTop, vWidth, vHeight)";
_act.AddView((android.view.View)(_pnl.getObject()),_vleft,_vtop,_vwidth,_vheight);
 //BA.debugLineNum = 41;BA.debugLine="cvs.Initialize(pnl)";
_cvs.Initialize((android.view.View)(_pnl.getObject()));
 //BA.debugLineNum = 43;BA.debugLine="joy.zeroX = pnl.Height / 2";
_joy.zeroX = (float)(_pnl.getHeight()/(double)2);
 //BA.debugLineNum = 44;BA.debugLine="joy.zeroY = pnl.Height / 2";
_joy.zeroY = (float)(_pnl.getHeight()/(double)2);
 //BA.debugLineNum = 48;BA.debugLine="MoveJoystick(joy.zeroX, joy.zeroY, joy)";
_movejoystick(_joy.zeroX,_joy.zeroY,_joy);
 //BA.debugLineNum = 50;BA.debugLine="pnl.Invalidate";
_pnl.Invalidate();
 //BA.debugLineNum = 51;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 8;BA.debugLine="Type joystick(DestRect As Rect, x As Float, y As Float, zeroX As Float, zeroY As Float, color As Int)";
;
 //BA.debugLineNum = 9;BA.debugLine="Dim joy As joystick";
_joy = new gamepad._joystick();
 //BA.debugLineNum = 10;BA.debugLine="Private radius As Int";
_radius = 0;
 //BA.debugLineNum = 11;BA.debugLine="radius = 50dip";
_radius = __c.DipToCurrent((int)(50));
 //BA.debugLineNum = 12;BA.debugLine="End Sub";
return "";
}
public int  _getjoyvalue() throws Exception{
 //BA.debugLineNum = 92;BA.debugLine="Public Sub GetJoyValue As Int";
 //BA.debugLineNum = 93;BA.debugLine="Return GetValue(joy)";
if (true) return _getvalue(_joy);
 //BA.debugLineNum = 94;BA.debugLine="End Sub";
return 0;
}
public int  _getvalue(gamepad._joystick _j) throws Exception{
 //BA.debugLineNum = 97;BA.debugLine="Private Sub GetValue(j As joystick) As Int";
 //BA.debugLineNum = 99;BA.debugLine="End Sub";
return 0;
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 14;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 15;BA.debugLine="pnl.Initialize(\"\")";
_pnl.Initialize(ba,"");
 //BA.debugLineNum = 19;BA.debugLine="ges.SetOnTouchListener(pnl, \"pnl_multitouch\")";
_ges.SetOnTouchListener(ba,(android.view.View)(_pnl.getObject()),"pnl_multitouch");
 //BA.debugLineNum = 20;BA.debugLine="joy.Initialize";
_joy.Initialize();
 //BA.debugLineNum = 21;BA.debugLine="joy.color = Colors.ARGB(115, 112, 112, 100)";
_joy.color = __c.Colors.ARGB((int)(115),(int)(112),(int)(112),(int)(100));
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return "";
}
public String  _movejoystick(float _x,float _y,gamepad._joystick _j) throws Exception{
float _valuex = 0f;
float _valuey = 0f;
 //BA.debugLineNum = 79;BA.debugLine="Private Sub MoveJoystick(x As Float, y As Float, j As joystick)";
 //BA.debugLineNum = 80;BA.debugLine="cvs.DrawCircle(j.x, j.y, radius, Colors.Transparent, True, 0) 'cancella la traccia precedente";
_cvs.DrawCircle(_j.x,_j.y,(float)(_radius),__c.Colors.Transparent,__c.True,(float)(0));
 //BA.debugLineNum = 81;BA.debugLine="Dim valuex, valuey As Float";
_valuex = 0f;
_valuey = 0f;
 //BA.debugLineNum = 82;BA.debugLine="valuex = x - j.zeroX";
_valuex = (float)(_x-_j.zeroX);
 //BA.debugLineNum = 83;BA.debugLine="valuey = y - j.zeroY";
_valuey = (float)(_y-_j.zeroY);
 //BA.debugLineNum = 85;BA.debugLine="If j.zeroX == x AND j.zeroY == y Then valuex = x: valuey = y";
if (_j.zeroX==_x && _j.zeroY==_y) { 
_valuex = _x;};
 //BA.debugLineNum = 85;BA.debugLine="If j.zeroX == x AND j.zeroY == y Then valuex = x: valuey = y";
_valuey = _y;
 //BA.debugLineNum = 86;BA.debugLine="j.x = x";
_j.x = _x;
 //BA.debugLineNum = 87;BA.debugLine="j.y = y";
_j.y = _y;
 //BA.debugLineNum = 88;BA.debugLine="cvs.DrawCircle(j.x, j.y, radius, j.color, True, 0)";
_cvs.DrawCircle(_j.x,_j.y,(float)(_radius),_j.color,__c.True,(float)(0));
 //BA.debugLineNum = 90;BA.debugLine="End Sub";
return "";
}
public boolean  _pnl_multitouch(Object _view,int _pointerid,int _action,float _x,float _y) throws Exception{
boolean _foundleft = false;
int _i = 0;
float _gx = 0f;
float _gy = 0f;
 //BA.debugLineNum = 53;BA.debugLine="Private Sub pnl_multitouch(View As Object, pointerID As Int, action As Int, x As Float, Y As Float) As Boolean";
 //BA.debugLineNum = 54;BA.debugLine="Dim foundLeft As Boolean";
_foundleft = false;
 //BA.debugLineNum = 55;BA.debugLine="For i = 0 To ges.GetPointerCount - 1";
{
final double step30 = 1;
final double limit30 = (int)(_ges.GetPointerCount()-1);
for (_i = (int)(0); (step30 > 0 && _i <= limit30) || (step30 < 0 && _i >= limit30); _i += step30) {
 //BA.debugLineNum = 56;BA.debugLine="Log(\" ---------------- \")";
__c.Log(" ---------------- ");
 //BA.debugLineNum = 57;BA.debugLine="Log(\"i = \"&NumberFormat(i, 1, 0))";
__c.Log("i = "+__c.NumberFormat(_i,(int)(1),(int)(0)));
 //BA.debugLineNum = 58;BA.debugLine="Log(\"X = \"&NumberFormat(ges.GetX(i), 1, 0))";
__c.Log("X = "+__c.NumberFormat(_ges.GetX(_i),(int)(1),(int)(0)));
 //BA.debugLineNum = 59;BA.debugLine="Log(\"Y = \"&NumberFormat(ges.GetY(i), 1, 0))";
__c.Log("Y = "+__c.NumberFormat(_ges.GetY(_i),(int)(1),(int)(0)));
 //BA.debugLineNum = 60;BA.debugLine="If (action = ges.ACTION_UP OR action = ges.ACTION_POINTER_UP) AND _ 			ges.GetPointerID(i) = pointerID Then";
if ((_action==_ges.ACTION_UP || _action==_ges.ACTION_POINTER_UP) && _ges.GetPointerID(_i)==_pointerid) { 
 //BA.debugLineNum = 62;BA.debugLine="Continue";
if (true) continue;
 };
 //BA.debugLineNum = 64;BA.debugLine="If ges.GetX(i) = -1 AND ges.GetY(i) = -1 Then Continue";
if (_ges.GetX(_i)==-1 && _ges.GetY(_i)==-1) { 
if (true) continue;};
 //BA.debugLineNum = 65;BA.debugLine="Dim gx, gy As Float";
_gx = 0f;
_gy = 0f;
 //BA.debugLineNum = 66;BA.debugLine="gx = Max(0, Min(ges.GetX(i), pnl.Width))";
_gx = (float)(__c.Max(0,__c.Min(_ges.GetX(_i),_pnl.getWidth())));
 //BA.debugLineNum = 67;BA.debugLine="gy = Max(0, Min(ges.GetY(i), pnl.Height))";
_gy = (float)(__c.Max(0,__c.Min(_ges.GetY(_i),_pnl.getHeight())));
 //BA.debugLineNum = 69;BA.debugLine="gx = Min(gx, pnl.Height)";
_gx = (float)(__c.Min(_gx,_pnl.getHeight()));
 //BA.debugLineNum = 70;BA.debugLine="foundLeft = True";
_foundleft = __c.True;
 //BA.debugLineNum = 71;BA.debugLine="MoveJoystick(gx, gy, joy)";
_movejoystick(_gx,_gy,_joy);
 }
};
 //BA.debugLineNum = 74;BA.debugLine="If Not(foundLeft) Then MoveJoystick(joy.zeroX, joy.zeroY, joy)";
if (__c.Not(_foundleft)) { 
_movejoystick(_joy.zeroX,_joy.zeroY,_joy);};
 //BA.debugLineNum = 75;BA.debugLine="pnl.Invalidate";
_pnl.Invalidate();
 //BA.debugLineNum = 76;BA.debugLine="Return True";
if (true) return __c.True;
 //BA.debugLineNum = 77;BA.debugLine="End Sub";
return false;
}
}
