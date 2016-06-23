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
			// ���ý���Ӳ�͸��->͸����1��ʾ��͸����0��ʾ͸��
			AlphaAnimation alpha = new AlphaAnimation(1f, 0f);
			// ����ִ�е�ʱ��
			alpha.setDuration(1000);
			set.addAnimation(alpha);
			break;
		case R.id.rotate_button:
			// RotateAnimation rotate = new RotateAnimation(0, 180, 0,
			// 0);//��0����ת��180�ȣ������Ͻǣ�0,0��ΪԲ��
			// �����������(Բ����ͼƬ������)��ת360�ȣ�
			// x����������ڸ��ؼ����һ�룬y�����������ߵ�һ�룬����ȷ��һ��Բ��
			RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_PARENT, 0.5f, // 0.5//
																										// =//
																										// 1/2���Լ����ؼ��ĳ���

					Animation.RELATIVE_TO_SELF, 0.5f);// 0.5 = 1/2���Լ��ĳ���
			rotate.setDuration(5000);
			set.addAnimation(rotate);
			break;
		case R.id.scale_button:
			// ���Ŷ�����x�����1f->2f��y�����1f->2f�����ŵ�����������Լ���һ�룬�������Լ�������
			ScaleAnimation scale = new ScaleAnimation(1f, 2f, 1f, 2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
			scale.setDuration(1000);
			set.addAnimation(scale);
			break;
		case R.id.translate_button:
			// �ƶ�����.x:��������Լ�x��Ϊ0��λ���ƶ���������Լ�x��Ϊ1��λ�á������Լ����ұ��ƶ�һ����λ
			// y:��������Լ�y��Ϊ0��λ���ƶ���������Լ�y��Ϊ1��λ�á������Լ������ƶ���������λ
			TranslateAnimation translate = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 2f);
			translate.setDuration(1000);
			set.addAnimation(translate);
			break;
		default:
			break;
		}
		// ���ÿ�ʼ����
		iV.startAnimation(set);
	}

}
