Type=Class
Version=2.5
@EndOfDesignText@
'version: 1.00
Sub Class_Globals
	Private ges As Gestures
	Private pnl As Panel
	Private cvs As Canvas
	'Dim Stick As Bitmap

	Type joystick(DestRect As Rect, x As Float, y As Float, zeroX As Float, zeroY As Float, color As Int)
	Dim joy As joystick
	Private radius As Int
	radius = 50dip
End Sub

Public Sub Initialize
	pnl.Initialize("")
'	Dim cd As ColorDrawable
'	cd.Initialize ( Colors.ARGB( 200, 0, 0, 0) , 5dip )
'	pnl.Background = cd 
	ges.SetOnTouchListener(pnl, "pnl_multitouch")
	joy.Initialize
	joy.color = Colors.ARGB(115, 112, 112, 100)
'	joy.color = Colors.RGB(115, 112, 112)
	'Canvas1.DrawDrawable(GD,Rect1)
	'Stick.Initialize(File.DirAssets, "stick.png")
End Sub

Public Sub AddToActivity(act As Activity, vLeft As Int, vTop As Int, vWidth As Int, vHeight As Int)
	Dim iv1 As ImageView
	iv1.Initialize("")
	iv1.Bitmap = LoadBitmap(File.DirAssets, "ffjoy.png")
	iv1.Gravity = Gravity.FILL	
	act.AddView(iv1, vLeft, vTop, vHeight, vHeight)
	
'	Dim iv2 As ImageView
'	iv2.Initialize("")
'	iv2.Bitmap = LoadBitmap(File.DirAssets, "stick.png")
'	iv2.Gravity = Gravity.FILL
	
	
	act.AddView(pnl, vLeft, vTop, vWidth, vHeight)
	cvs.Initialize(pnl)
	
	joy.zeroX = pnl.Height / 2
	joy.zeroY = pnl.Height / 2
'	Dim v2Height As Int: v2Height = 100
'	act.AddView(iv2, joy.zeroX, joy.z, v2Height, v2Height)
    'DestRect.Initialize(10dip, 10dip, joy.zeroX, joy.zeroY)
	MoveJoystick(joy.zeroX, joy.zeroY, joy)
	
	pnl.Invalidate
End Sub

Private Sub pnl_multitouch(View As Object, pointerID As Int, action As Int, x As Float, Y As Float) As Boolean
	Dim foundLeft As Boolean
	For i = 0 To ges.GetPointerCount - 1
		Log(" ---------------- ")
		Log("i = "&NumberFormat(i, 1, 0))
		Log("X = "&NumberFormat(ges.GetX(i), 1, 0))
		Log("Y = "&NumberFormat(ges.GetY(i), 1, 0))
		If (action = ges.ACTION_UP OR action = ges.ACTION_POINTER_UP) AND _
			ges.GetPointerID(i) = pointerID Then
				Continue
		End If
		If ges.GetX(i) = -1 AND ges.GetY(i) = -1 Then Continue
		Dim gx, gy As Float
		gx = Max(0, Min(ges.GetX(i), pnl.Width))
		gy = Max(0, Min(ges.GetY(i), pnl.Height))
		'If gx < pnl.Width / 2 Then
			gx = Min(gx, pnl.Height)
			foundLeft = True
			MoveJoystick(gx, gy, joy)
		'End If
	Next
	If Not(foundLeft) Then MoveJoystick(joy.zeroX, joy.zeroY, joy)
	pnl.Invalidate
	Return True
End Sub

Private Sub MoveJoystick(x As Float, y As Float, j As joystick)
	cvs.DrawCircle(j.x, j.y, radius, Colors.Transparent, True, 0) 'cancella la traccia precedente
	Dim valuex, valuey As Float
	valuex = x - j.zeroX
	valuey = y - j.zeroY
	'If Abs(valuex) > Abs(valuey) Then y = j.zeroY Else x = j.zeroX
	If j.zeroX == x AND j.zeroY == y Then valuex = x: valuey = y 
	j.x = x
	j.y = y
	cvs.DrawCircle(j.x, j.y, radius, j.color, True, 0)
	'cvs.DrawBitmap(Stick, Null, DestRect) 'draws the bitmap to the destination rectangle.
End Sub

Public Sub GetJoyValue As Int
	Return GetValue(joy)
End Sub


Private Sub GetValue(j As joystick) As Int

End Sub