Type=Class
Version=2.5
@EndOfDesignText@
'version: 1.00
Sub Class_Globals
	Private ges As Gestures
	Private pnl As Panel
	Private cvs As Canvas 
	Type joystick(x As Float, y As Float, zeroX As Float, zeroY As Float, color As Int)
	Dim joy As joystick
	Private radius As Int: radius = 50dip 'radius of the stick	
	Dim r_max As Int: r_max = 35dip 'max distance between the center of the stick and the center of the pad
	Dim r_curr As Float: r_curr = 0 'current distance between the center of the stick and the center of the pad
	Dim Dx As Float: Dx = 0
	Dim Dy As Float: Dy = 0
End Sub

Public Sub Initialize
	pnl.Initialize("")
	ges.SetOnTouchListener(pnl, "pnl_multitouch")
	joy.Initialize
	joy.color = Colors.ARGB(115, 112, 112, 100)
'	joy.color = Colors.RGB(115, 112, 112)
End Sub

Public Sub AddToActivity(act As Activity, vLeft As Int, vTop As Int, vWidth As Int, vHeight As Int)
	Dim iv1 As ImageView
	iv1.Initialize("")
	iv1.Bitmap = LoadBitmap(File.DirAssets, "ffjoy.png")
	iv1.Gravity = Gravity.FILL	
	act.AddView(iv1, vLeft, vTop, vWidth, vHeight)	
	act.AddView(pnl, vLeft, vTop, vWidth, vHeight)
	cvs.Initialize(pnl)
	joy.zeroX = pnl.Height / 2
	joy.zeroY = pnl.Height / 2
	MoveJoystick(joy.zeroX, joy.zeroY, joy)	
	pnl.Invalidate
End Sub

Private Sub pnl_multitouch(View As Object, pointerID As Int, action As Int, x As Float, Y As Float) As Boolean
	Dim foundJoy As Boolean
	For i = 0 To ges.GetPointerCount - 1
		If (action = ges.ACTION_UP OR action = ges.ACTION_POINTER_UP OR action = ges.ACTION_DOWN) AND _
			ges.GetPointerID(i) = pointerID Then
				Continue
		End If
		If ges.GetX(i) = -1 AND ges.GetY(i) = -1 Then Continue
		Dim gx, gy As Float
		gx = Max(0, Min(ges.GetX(i), pnl.Width))
		gy = Max(0, Min(ges.GetY(i), pnl.Height))
		foundJoy = True
		MoveJoystick(gx, gy, joy)
	Next
	If Not(foundJoy) Then MoveJoystick(joy.zeroX, joy.zeroY, joy)
	pnl.Invalidate
	Return True
End Sub

Private Sub MoveJoystick(x As Float, y As Float, j As joystick)
	cvs.DrawCircle(j.x, j.y, radius, Colors.Transparent, True, 0) 'delete previous track
	Dx = x - j.zeroX
	Dy = j.zeroY - y
	Dim r As Float: r = ComputeDist(x,y,j)	
	Dim angle As Float: angle = ComputeAngle(Dx,Dy)
	If r < r_max Then
		j.x = x
		j.y = y
	Else
		j.x = r_max*Cos(angle)+j.zeroX
		j.y = -r_max*Sin(angle)+j.zeroY
	End If	
	cvs.DrawCircle(j.x, j.y, radius, j.color, True, 0)
End Sub

Private Sub ComputeDist(x As Float, y As Float, j As joystick) As Float
	Return Sqrt(Power(x - j.zeroX, 2)+Power(y - j.zeroY, 2))
End Sub

Private Sub ComputeAngle(x As Float, y As Float) As Float
	If x > 0 AND y >= 0 Then
		Return ATan(y/x)
	Else If x > 0 AND y < 0 Then
		Return ATan(y/x) + 2*cPI
	Else If x < 0 Then
		Return ATan(y/x) + cPI	
	Else If x == 0 AND y > 0 Then
		Return cPI/2	
	Else If x == 0 AND y < 0 Then
		Return 3*cPI/2	
	Else 
		Return 0
	End If	
End Sub
Public Sub GetJoyValue As Float()
	Dim v(2) As Float
	Dim r_curr As Float: r_curr = ComputeDist(joy.x,joy.y,joy)
	v(0) = r_curr/r_max 'normalized linear velocity [m/s]
	v(1) = ATan2(Dx,Dy) 'angular vel [rad/s]
	Return v
End Sub

