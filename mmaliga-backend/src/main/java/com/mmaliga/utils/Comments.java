package com.mmaliga.utils;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Comments {

	public static final ArrayList<String> apresentation = new ArrayList<String>(Arrays.asList(
		
		    "Senhoras e senhores. Essa luta é de %d rounds, na divisão dos %s! %n"
			+ "Apresentando o lutador à minha esquerda, lutando no córner vermelho. %n"
			+ "Com um cartel de %s-%s-%s, %s! %n"
			+ "E apresentando o lutador à minha direita, lutando pelo córner azul. %n"
			+ "Com um cartel de %s-%s-%s, %s! %n",
			
			"Senhoras e senhores. Essa luta é de %d rounds, pelo cinturão dos  %s! %n"
		    + "Apresentando o campeão à minha esquerda, lutando no canto vermelho. %n"
		    + "Com um cartel de %s-%s-%s, %s! %n"
		    + "E apresentando o desafiante à minha direita, lutando no canto azul. %n"
		    + "Com um cartel de %s-%s-%s, %s! %n"));
	
	public static final ArrayList<String> punch1 = new ArrayList<String>(Arrays.asList(
	"%act tries a hook to the body;and hits %pas's ribs hard;but %pas manages to dodge it;10;1;2;3;Hook to the body;1;1;-10;0;-5;1;1;"
));
	
	public static final ArrayList<String> punch2 = new ArrayList<String>(Arrays.asList(
	"%act tries a hook to the body;and hits %pas ribs hard;but %pas manages to dodge it"
));
	
	public static final ArrayList<String> punch3 = new ArrayList<String>(Arrays.asList(
	"%a2 begins to launch a barrage of punches over %pas;this is getting worse and worse for %pas, %d1 is smart enough to duck backwards"));
	
	
	public static final ArrayList<String> counter = new ArrayList<String>(Arrays.asList(
		   "%s está tentando contra-atacar agora!",
			"%s falha desajeitadamente aqui e é hora de %s revidar!",
			"%s tenta obter alguma vantagem após seu oponente errar o movimento...",
			"%s fica desleixado e %s tenta tirar vantagem...",
			"Técnica mal executada. %s procura contra-atacar!",
			"%s erra um passo e %s vê uma oportunidade de contra-atacar!"));
	
	
	public static final ArrayList<String> groundKO = new ArrayList<String>(Arrays.asList(
		   "This is over! That impact from %act has left %pas laying flat on the mat!",
			"%act turns out the lights for %pas! What an astonishing KO by %a2!",
			"That brutal impact left %pas laid out on the mat! %act's corner come in to congratulate him!"));
	
	public static final ArrayList<String> standingKO = new ArrayList<String>(Arrays.asList(
			"%pas hits the ground hard! That crushing blow from %act has left %pas unconscious! What a finish by %act!",
			"%pas hits the ground like a rag doll! That surgical strike by %act has left %pas unconscious on the mat!",
			"%pas is out! %pas is out! %act has ended this fight in highlight reel fashion!",
			"Down %pas goes! He's out cold! That phenomenal knock out has put the rest of %act's divison on notice!",
			"That brutal impact left %pas laid out on the mat! %act's corner pours in to congratulate him!",
			"Oh! Down goes %pas! %act knocked him stupid! The medics pour in! %act really wanted to win this fight"
			+ " and has done it in an impressive manner.",
			"%act landed the knock out blow that he wanted! %pas is down! %pas has been absolutely destroyed here! A great victory for %act!",
			"%pas hit the ground like he got hit with a baseball bat! %act knocks %pas out cold in a stunning fashion!",
			"%act turns out the lights for %pas! Tiiiiiiiim-ber! What a knock out!",
			"%pas fell like he got shot! This is over!",
			"The frightening power of %act has left %pas sleeping peacefully on the canvas!",
			"%pas crumples to the mat and %a2 moves in to finish him. The referee jumps in and stops the fight!"
	));
	
	public static final ArrayList<String> misc = new ArrayList<String>(Arrays.asList(
			"The fight goes to the judges.",
			"Judge:",
			"Winner is",
			"Unanimous decision",
			"Split decision",
			"Majority decision",
			"Majority draw",
			"Draw",
			"by",
			"between",
			"Punches",
			"Kicks",
			"Takedowns",
			"Clinch strikes",
			"Submissions",
			"GnP strikes",
			"Statistics",
			"Damage caused",
			"Time on the ground",
			"Forehead",
			"Left eye",
			"Right eye",
			"Left cheek",
			"Right cheek",
			"Nose",
			"Mouth",
			"Chin",
			"Upper body",
			"Ribs",
			"Abdomen",
			"Back",
			"Left arm",
			"Right arm",
			"Left thigh",
			"Right thigh",
			"Left Knee",
			"Right knee",
			"Left foot",
			"Right foot",
			"KO",
			"TKO",
			"Submission",
			"Injury",
			"No contest",
			"Disqualification",
			"Time Out",
			"Record",
			"Clinch Attempts",
			"Clinch Damage",
			"Ground Damage",
			"Average Damage",
			"Caused",
			"Received",
			"Damage",
			"Cut",
			"Doctor Stoppage",
			"The referee of the bout is %ref.",
			"Freakshow",
			"Unfair",
			"Mismatch",
			"Fair",
			"Great Match",
			"Very Anticipated",
			"Dream Match",
			"The event takes place at %venue",
			"Attendance",
			"PPV buys",
			"Prelim card excitement",
			"Main card excitement",
			"Main and Co-Main event excitement",
			"Overall event quality",
			"Fights played",
			"SHW",
			"HW",
			"LHW",
			"MW",
			"WW",
			"LW",
			"FW",
			"BW",
			"Bout",
			"(T)KOs",
			"Injuries",
			"Decisions",
			"Disqualification",
			"Average Duration",
			"Most used referee",
			"Most used organization",
			"Total Duration",
			"Any organization",
			"Unknown",
			"%act has broken the record of",
			"most damage caused in a fight",
			"most damage cause by a single attack",
			"fastest KO",
			"fastest submission",
			"Round",
			"%act has fight %d1 %param1 times.",
			"He has won %param2 of them.",
			"This is the first time they meet inside the %site",
			"He has lost %param2 of them.",
			"Towel Throw",
			"groin kick",
			"eye poke",
			"headbutt",
			"strangle",
			"%act defends the %param1 title!",
			"%act wins the %param1 title!",
			"Fighters will fight a tie break round.",
			"%act wins %param1 ranking points after the fight.",
			"%act loses %param1 ranking points after the fight.",
			"%act and %d1 had today the best fight of this organization!",
			"%act and %d1 had today the worst fight of this organization!",
			"%act comes with a %param1 fight winning streak.",
			"%act comes with a %param1 fight losing streak.",
			"Very Boring",
			"Dull",
			"Average",
			"Promising",
			"Exciting"
	));
	
	public static final ArrayList<String> tkoRef = new ArrayList<String>(Arrays.asList(
	"%ref has seen enough! The fight is over! %pas was not intelligently defending himself!",
	"The ref pulls off %act! %pas seems confused and a bit dazed as the bell sounds the bout over.",
	"%ref is asking %pas to defend himself! %ref jumps in between the fighters and stops the punishment for %pas."));
	
	public static final ArrayList<String> faceCut0 = new ArrayList<String>(Arrays.asList(
	"%pas has a small cut in his %location;Small cut %location",
	"There is a small laceration on %d1's %location;Small cut %location"));
	
	
	
	
}