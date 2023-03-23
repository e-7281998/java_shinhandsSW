package com.shinhan.day05;

public class TV implements Volume {

	int volLevel;

	@Override
	public void volumeUp(int volLevel) {
		this.volLevel += volLevel;
		System.out.println(getClass().getSimpleName() +"볼륨을 올립니다." + this.volLevel);
	}

	@Override
	public void volumeDown(int volLevel) {
		this.volLevel -= volLevel;
		if(this.volLevel < 0)	volLevel = 0;
		System.out.println(getClass().getSimpleName() +"볼륨을 내립니다." + this.volLevel);
	}

}
