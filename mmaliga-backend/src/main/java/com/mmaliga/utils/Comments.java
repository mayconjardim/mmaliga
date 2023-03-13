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
			"%act tries a hook to the body;and hits %pas's ribs hard;but %pas manages to dodge it;10;1;2;3;Hook to the body;1;1;-10;0;-5;1;1",
			"%act fakes a move and launches a nice uppercut;it lands on %pas's chin;%pas blocks that. It was easy!;8;2;3;2;Uppercut;1;1;0;0;2;1;1;",
			"Brilliant combination from %act;that forces %pas to try and defend better.;%pas is showing some dodging skills avoiding that ones.;7;2;1;3;Punches;4;3;2;2;1;1;1",
			"Bone shattering straight right hand from %act!;%pas is going to have a big headache after that blow!;%pas ducks under...;4;1;2;4;Punch;1;1;1;1;1;1;1",
			"Bone shattering straight left hand from %act!;%pas is going to have a big headache after that blow!;%pas ducks under...;5;1;2;4;Punch;1;1;1;1;1;1;1",
			"Tremendous strikes from %act!;Some big punches are landing!;%pas blocks with confidence;8;3;1;2;Punches;3;3;2;2;3;1;1",
			"%act launches a hook to the body;Bang! %pas stops that one with his ribs!;%pas moves aside looking for a counter...;10;4;1;2;Punch;1;1;0;2;0;1;1",
			"%act throws a punch;that finds an opening in the defense of %pas.;that gets deflected.;0;2;1;2;Punch;1;1;0;0;0;1;1",
			"Solid jabs from %act.;Nice punches.;%pas defends.;0;1;1;2;Jabs;2;2;-1;-2;-1;1;1",
			"A solid combination from %act;connects with %pas.;mostly hits air.;0;2;1;2;Punches;2;2;1;0;0;1;1",
			"%act is measuring %pas with his jab.;Good accuracy on his part.;%pas isn't fazed.;0;1;1;2;Jabs;2;2;-1;-2;-1;1;1",
			"Solid shot from %act to the body.;%pas didn't like that.;%pas blocks in time.;9;2;1;4;Body punch;1;1;-5;1;0;1;1",
			"Some counter punches against %pas; land while he's on his bicycle.;almost hit him as he moves away.;0;1;4;1;Punches;2;2;0;-1;0;1;1",
			"Good movement from %act;moving in to strike and moving away afterwards.;who is bobbing and weaving.;0;0;1;3;Punches;2;2;1;0;0;1;1",
			"%act fires an unorthodox punch to %pas's torso;that hits its mark.;that goes wide.;11;2;1;2;Body punch;1;1;-5;-1;-3;1;1",
			"A punch from %act;grazes %pas's left cheek.;whizzes past %pas.;4;2;1;4;Punch;1;1;0;-1;0;1;1",
			"A punch from %act;grazes %pas's right cheek.;gets blocked by %pas.;5;2;1;4;Punch;1;1;0;-1;0;1;1",
			"%act jabs at %pas;hitting his chest.;to no visible effect.;9;2;1;2;Jab;1;1;-5;-1;-2;1;1",
			"%act launches a flurry of punches;but only manages to land glancing blows.;%pas slips out of danger.;0;3;1;3;Punches;3;2;0;-1;0;1;1"
	));

	public static final ArrayList<String> punch2 = new ArrayList<String>(Arrays.asList(
			"%act tries a hook to the body;and hits %pas's ribs hard;but %pas manages to dodge it",

			"%act fakes a move and launches a nice uppercut;it lands on %pas's chin;%pas blocks that. It was easy!",

			"Brilliant combination from %act;that forces %pas to try and defend better.;%pas is showing some dodging skills avoiding that ones.",

			"Bone shattering straight right hand from %act!;%pas is going to have a big headache after that blow!;%pas ducks under...",

			"Bone shattering straight left hand from %act!;%pas is going to have a big headache after that blow!;%pas ducks under...",

			"Tremendous strikes from %act!;Some big punches are landing!;%pas blocks with confidence",

			"%act launches a hook to the body;Bang! %pas stops that one with his ribs!;%pas moves aside looking for a counter...",

			"%act throws a punch;that finds an opening in the defense of %pas.;that gets deflected.",

			"Solid jabs from %act.;Nice punches.;%pas defends.",

			"A solid combination from %act;connects with %pas.;mostly hits air.",

			"%act is measuring %pas with his jab.;Good accuracy on his part.;%pas isn't fazed.",

			"Solid shot from %act to the body.;%pas didn't like that.;%pas blocks in time.",

			"Some counter punches against %pas; land while he's on his bicycle.;almost hit him as he moves away.",

			"Good movement from %act;moving in to strike and moving away afterwards.;who is bobbing and weaving.",

			"%act fires an unorthodox punch to %pas's torso;that hits its mark.;that goes wide.",

			"A punch from %act;grazes %pas's left cheek.;whizzes past %pas.",

			"A punch from %act;grazes %pas's right cheek.;gets blocked by %pas.",

			"%act jabs at %pas;hitting his chest.;to no visible effect.",

			"%act launches a flurry of punches;but only manages to land glancing blows.;%pas slips out of danger."
	
	));

	public static final ArrayList<String> punch3 = new ArrayList<String>(Arrays.asList(

	));

	public static final ArrayList<String> kicks1 = new ArrayList<String>(Arrays.asList(
			"Low kick by %act to maintain his distance.;That hits %pas's ankle;Bad move. That was far from landing.",
			"Low kick by %act to maintain his distance.;That hits %pas's ankle;Bad move. That was far from landing",
			"%act moves forward and launches a low kick.;Hard blow to %pas's left thigh;%pas blocks that",
			"%act moves forward and launches a low kick.;Hard blow to %pas's right thigh;%pas blocks that",
			"%act is not showing a great technique with that low kick...;That one finds %pas's thigh;%pas is smart enough to block that one",
			"Body kick by %act...;just grazes his opponent.",
			"A high kick from %act;grazes %pas's head, but he seems okay.;falls short of the mark",
			"A high kick from %act;glances off %pas.;misses badly. %act slips and falls!",
			"A bunch of leg kicks from %act;are bothering his opponent.;are blocked by %pas.",
			"%act throws a body kick.;Solid shot!;Blocked by %pas.",
			"Good leg kicks from %act.;%pas winces a bit.;%pas defends with ease.",
			"Every time %pas attempts to get inside;%act fires a low kick.;%act misses with a low kick",
			"Nice low kick from %act;Loud pop!;but %pas stops it"));

	public static final ArrayList<String> counter = new ArrayList<String>(Arrays.asList(
			"%act is trying to counter now!", "%pas clumsily fails here and it's time for %act to fight back!",
			"%act tries to get some advantage after his opponent miss move...",
			"%pas gets sloppy and %act tries to take advantage...", "Poorly executed technique. %act looks to counter!",
			"%act misses a step and %pas sees an opportunity to counter him!"));

	public static final ArrayList<String> groundKO = new ArrayList<String>(
			Arrays.asList("This is over! That impact from %act has left %pas laying flat on the mat!",
					"%act turns out the lights for %pas! What an astonishing KO by %act!",
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
			"%pas crumples to the mat and %act moves in to finish him. The referee jumps in and stops the fight!"));

	public static final ArrayList<String> misc = new ArrayList<String>(Arrays.asList("The fight goes to the judges.",
			"Judge:", "Winner is", "Unanimous decision", "Split decision", "Majority decision", "Majority draw", "Draw",
			"by", "between", "Punches", "Kicks", "Takedowns", "Clinch strikes", "Submissions", "GnP strikes",
			"Statistics", "Damage caused", "Time on the ground", "Forehead", "Left eye", "Right eye", "Left cheek",
			"Right cheek", "Nose", "Mouth", "Chin", "Upper body", "Ribs", "Abdomen", "Back", "Left arm", "Right arm",
			"Left thigh", "Right thigh", "Left Knee", "Right knee", "Left foot", "Right foot", "KO", "TKO",
			"Submission", "Injury", "No contest", "Disqualification", "Time Out", "Record", "Clinch Attempts",
			"Clinch Damage", "Ground Damage", "Average Damage", "Caused", "Received", "Damage", "Cut",
			"Doctor Stoppage", "The referee of the bout is %ref.", "Freakshow", "Unfair", "Mismatch", "Fair",
			"Great Match", "Very Anticipated", "Dream Match", "The event takes place at %venue", "Attendance",
			"PPV buys", "Prelim card excitement", "Main card excitement", "Main and Co-Main event excitement",
			"Overall event quality", "Fights played", "SHW", "HW", "LHW", "MW", "WW", "LW", "FW", "BW", "Bout",
			"(T)KOs", "Injuries", "Decisions", "Disqualification", "Average Duration", "Most used referee",
			"Most used organization", "Total Duration", "Any organization", "Unknown", "%act has broken the record of",
			"most damage caused in a fight", "most damage cause by a single attack", "fastest KO", "fastest submission",
			"Round", "%act has fight %pas %param1 times.", "He has won %param2 of them.",
			"This is the first time they meet inside the %site", "He has lost %param2 of them.", "Towel Throw",
			"groin kick", "eye poke", "headbutt", "strangle", "%act defends the %param1 title!",
			"%act wins the %param1 title!", "Fighters will fight a tie break round.",
			"%act wins %param1 ranking points after the fight.", "%act loses %param1 ranking points after the fight.",
			"%act and %pas had today the best fight of this organization!",
			"%act and %pas had today the worst fight of this organization!",
			"%act comes with a %param1 fight winning streak.", "%act comes with a %param1 fight losing streak.",
			"Very Boring", "Dull", "Average", "Promising", "Exciting"));

	public static final ArrayList<String> tkoRef = new ArrayList<String>(Arrays.asList(
			"%ref has seen enough! The fight is over! %pas was not intelligently defending himself!",
			"The ref pulls off %act! %pas seems confused and a bit dazed as the bell sounds the bout over.",
			"%ref is asking %pas to defend himself! %ref jumps in between the fighters and stops the punishment for %pas."));

	public static final ArrayList<String> faceCut0 = new ArrayList<String>(
			Arrays.asList("%pas has a small cut in his %location;Small cut %location",
					"There is a small laceration on %pas's %location;Small cut %location"));

}