package com.incoherentglitch.mybillardassistant;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.*;

public class ShowSol extends View {
	
	Rect button = new Rect(); // Define the dimensions of the button here
	
	public ShowSol(Context context) {
		super(context);
		button.top    = 0;
		button.bottom = 100;
		button.left   = 0;
		button.right  = 100;
		System.out.println("ShowSol : Start");
	}
	
	public boolean onTouch(View v, MotionEvent event) {
    	System.out.println("ShowSol : onTouch Screen");
        return false;
    }
	

	Paint paint = new Paint();
	final float scale = getResources().getDisplayMetrics().density;
	
	int margin = 30; // 30 par defaut
	int border = 3;  //  3 par defaut
	double widthBillard, heightBillard;
	double cxb = -1, cyb = -1;
	double cxr = -1, cyr = -1;
	double cxj = -1, cyj = -1;
	double angle = -1;
	boolean showTrouver = false;
	
	int sizeOfBoule = 60;
	
	Canvas _canvas;
	
	@SuppressLint("DrawAllocation") public void onDraw(Canvas canvas){
		_canvas = canvas;
		
		margin = _canvas.getWidth()/20;
		border = margin/10;		
		
		widthBillard = _canvas.getWidth()-margin;
		heightBillard = _canvas.getHeight()-margin;
		
		
		paint.setColor(Color.BLACK);
		paint.setStrokeWidth(3);
		_canvas.drawRect(margin, margin, _canvas.getWidth()-margin, _canvas.getHeight()-margin, paint);
		
		paint.setColor(Color.argb(255, 43, 135, 60));
		_canvas.drawRect(margin +border, margin +border, _canvas.getWidth() -margin -border, _canvas.getHeight() -margin -border, paint);
	
		if(cxb > 0 && cyb > 0){
			paint.setColor(Color.WHITE);
			_canvas.drawCircle(
					(float)(margin + widthBillard*cxb), 
					(float)(margin + heightBillard - heightBillard*cyb), 
					sizeOfBoule, paint);
		}
		
		if(cxr > 0 && cyr > 0){
			paint.setColor(Color.RED);
			_canvas.drawCircle(
					(float)(margin + widthBillard*cxr), 
					(float)(margin + heightBillard - heightBillard*cyr), 
					sizeOfBoule, paint);
		}
		
		if(cxj > 0 && cyj > 0){
			paint.setColor(Color.YELLOW);
			_canvas.drawCircle((float)(margin + widthBillard*cxj), 
					(float)(margin + heightBillard - heightBillard*cyj), 
					sizeOfBoule, paint);
		}
		
		if(angle < 0){
			String txt = "Calcul en cours...";
			int sizeOfText = margin*2/3;
			if(paint.measureText(txt) > _canvas.getWidth()/3)
				sizeOfText = determineMaxTextSize(txt, _canvas.getWidth()/3);
			
			paint.setColor(Color.argb(220, 0, 0, 0));
			_canvas.drawRect(
					_canvas.getWidth()/3 					-margin*2, 
					_canvas.getHeight()/2 	-sizeOfText/2 	-margin, 
					_canvas.getWidth()*2/3					+margin*2, 
					_canvas.getHeight()/2 	+sizeOfText/2 	+margin, paint);
			
			paint.setColor(Color.WHITE);			
			 paint.setTextSize(sizeOfText);
			_canvas.drawText(txt, _canvas.getWidth()/3 + ((_canvas.getWidth()/3) - paint.measureText(txt))/2, _canvas.getHeight()/2 +sizeOfText/4, paint);
		}else if(cxb > 0 && cyb > 0){
			// affichage de la queue
			double angleOpo = angle -Math.PI;
			if(angleOpo < 0) angleOpo += 2*Math.PI;
			double angleCal = angleOpo;
			while(angleCal > Math.PI/2){
				angleCal -= Math.PI/2;
			}
			double x1 = margin + widthBillard*cxb, y1 = (margin + heightBillard - heightBillard*cyb);
			double x2 = x1, y2 = y1;			
			int longueurQueue = (int) (widthBillard/2);
			if(angleOpo < Math.PI/2){
				x1 += sizeOfBoule * Math.cos(angleCal);
				y1 -= sizeOfBoule * Math.sin(angleCal);
				x2 += (longueurQueue+sizeOfBoule) * Math.cos(angleCal);
				y2 -= (longueurQueue+sizeOfBoule) * Math.sin(angleCal);
			}else if (angleOpo < Math.PI){
				x1 -= sizeOfBoule * Math.sin(angleCal);
				y1 -= sizeOfBoule * Math.cos(angleCal);
				x2 -= (longueurQueue+sizeOfBoule) * Math.sin(angleCal);
				y2 -= (longueurQueue+sizeOfBoule) * Math.cos(angleCal);		
			}else if (angleOpo < Math.PI*3/2){
				x1 -= sizeOfBoule * Math.cos(angleCal);
				y1 += sizeOfBoule * Math.sin(angleCal);
				x2 -= (longueurQueue+sizeOfBoule) * Math.cos(angleCal);
				y2 += (longueurQueue+sizeOfBoule) * Math.sin(angleCal);
			}else{
				x1 += sizeOfBoule * Math.sin(angleCal);
				y1 += sizeOfBoule * Math.cos(angleCal);
				x2 += (longueurQueue+sizeOfBoule) * Math.sin(angleCal);
				y2 += (longueurQueue+sizeOfBoule) * Math.cos(angleCal);
			}
			
			paint.setColor(Color.RED);
			paint.setStrokeWidth(6);
			_canvas.drawLine((float)x1, (float)y1, (float)x2, (float)y2, paint);
			
			// affichage du message de r�ussite
			if(showTrouver){
				String txt = "Calcul fini - Angle=" + (int)(angle/Math.PI*180) + "�";
				int sizeOfText = margin*2/3;
				if(paint.measureText(txt) > _canvas.getWidth()/3)
					sizeOfText = determineMaxTextSize(txt, _canvas.getWidth()/3);
				
				paint.setColor(Color.argb(220, 0, 0, 0));
				_canvas.drawRect(
						_canvas.getWidth()/3 					-margin*2, 
						_canvas.getHeight()/2 	-sizeOfText/2 	-margin, 
						_canvas.getWidth()*2/3					+margin*2, 
						_canvas.getHeight()/2 	+sizeOfText/2 	+margin, paint);
				
				paint.setColor(Color.argb(220, 90, 167, 45));
				paint.setTextSize(sizeOfText);
				_canvas.drawText(txt, _canvas.getWidth()/3 + ((_canvas.getWidth()/3) - paint.measureText(txt))/2, _canvas.getHeight()/2 +sizeOfText/4, paint);
			}			
		}
	}
	
	private int determineMaxTextSize(String str, float maxWidth)
	{
	    int size = 0;       
	    Paint paint = new Paint();

	    do {
	        paint.setTextSize(++size);
	    } while(paint.measureText(str) < maxWidth);

	    return size;
	}
	
	public void drawBoule(double cx, double cy, int color){
		//System.out.println("drawBoule(" + cx + ", " + cy + ", " + color + ")");
		if(color == Color.WHITE){
			this.cxb = cx;
			this.cyb = cy;
		}else if(color == Color.RED){
			this.cxr = cx;
			this.cyr = cy;
		}else if(color == Color.YELLOW){
			this.cxj = cx;
			this.cyj = cy;
		}
	}
	
	Date interestingDate = new Date();
	private static final ScheduledExecutorService worker = 
			  Executors.newSingleThreadScheduledExecutor();
	public void setAngle(double angle){
		this.angle = angle;
		showTrouver = true;
		
		final Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			public void run() {
				showTrouver = false;
				update();
			}
		}, 3000);
	}
	public void hideMsg(){
		showTrouver = false;
	}
	
	public void update(){
		this.invalidate();
	}
}
