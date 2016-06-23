package com.example.ts;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends ActionBarActivity {

	ImageView iV;
	AnimationSet set;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.animation);
		iV = (ImageView) findViewById(R.id.imageView);
		set = new AnimationSet(true);
	}

	public void buttonListener(View v) {

		switch (v.getId()) {
		case R.id.alpha_button:
			// 设置渐变从不透明->透明，1表示不透明，0表示透明
			AlphaAnimation alpha = new AlphaAnimation(1f, 0f);
			// 设置执行的时间
			alpha.setDuration(1000);
			set.addAnimation(alpha);
			break;
		case R.id.rotate_button:
			// RotateAnimation rotate = new RotateAnimation(0, 180, 0,
			// 0);//从0度旋转到180度，以左上角（0,0）为圆心
			// 从相对于自身(圆心在图片的中心)旋转360度，
			// x轴坐标相对于父控件宽的一半，y轴相对于自身高的一半，于是确定一个圆心
			RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_PARENT, 0.5f, // 0.5//
																										// =//
																										// 1/2的自己父控件的长度

					Animation.RELATIVE_TO_SELF, 0.5f);// 0.5 = 1/2的自己的长度
			rotate.setDuration(5000);
			set.addAnimation(rotate);
			break;
		case R.id.scale_button:
			// 缩放动画，x坐标从1f->2f，y坐标从1f->2f。缩放的轴是相对于自己的一半，等于是自己的中心
			ScaleAnimation scale = new ScaleAnimation(1f, 2f, 1f, 2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
			scale.setDuration(1000);
			set.addAnimation(scale);
			break;
		case R.id.translate_button:
			// 移动动画.x:从相对于自己x轴为0的位置移动到相对于自己x轴为1的位置。等于自己向右边移动一个身位
			// y:从相对于自己y轴为0的位置移动到相对于自己y轴为1的位置。等于自己向下移动了两个身位
			TranslateAnimation translate = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 2f);
			translate.setDuration(1000);
			set.addAnimation(translate);
			break;
		default:
			break;
		}
		// 设置开始动画
		iV.startAnimation(set);
	}

}
