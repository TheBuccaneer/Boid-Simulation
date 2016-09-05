package ai.gui.view.classes;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ai.MainApp;
import ai.gui.model.Model;
import ai.gui.view.MyView;
import ai.swarm.mode.MyMode;
import ai.swarm.mode.classes.Obstacle_Avoidance_Mode;
import ai.swarm.mode.classes.Open_World_Mode;
import ai.swarm.mode.classes.Path_Finding_Mode;
import ai.swarm.mode.classes.Pursuing_Mode;
import ai.swarm.mode.classes.Reynold_Rules_Mode;
import ai.swarm.mode.classes.Seek_and_Flee_Mode;
import ai.swarm.mode.classes.Wanderer_Mode;

public class Information extends JPanel implements MyView
{

	private Model model;
	private JLabel info = new JLabel(
			"Wei� = Auswahl m�glich, Grau = Deaktiviert, Gr�n = Aktiviert");

	public Information(Model model)
	{
		this.model = model;
		this.model.addMyView(this);
		this.setBackground(MainApp.BACK);
		this.setLayout(new GridLayout(0, 1));
		info.setForeground(MainApp.FRONT);
	}

	@Override
	public void changed()
	{
		MyMode mode = model.getMyMode();
		this.removeAll();
		if (mode instanceof Reynold_Rules_Mode)
		{
			JLabel l = new JLabel(
					"Scattering ohne Flocking nicht m�glich. 1 = Innerer Einflussbereich, 2 = �u�erer Einflussbereich (vgl. Arbeit S. 3 )");
			l.setForeground(MainApp.FRONT);
			this.add(l);

		} else if (mode instanceof Seek_and_Flee_Mode)
		{
			JLabel l = new JLabel(
					"Scattering, Seeking und Fleeing ohne Flocking nicht m�glich. Maus ist Objekt f�r das Suchen und Fliehen");
			l.setForeground(MainApp.FRONT);
			this.add(l);

		} else if (mode instanceof Wanderer_Mode)
		{
			JLabel l = new JLabel(
					"Wandering ohne Flocking nicht m�glich. Implementiert wurden zwei Wander-Varianten. Hier gezeigt ist einfache Eigenimplementierung (2. nach Reynolds in Open World");
			l.setForeground(MainApp.FRONT);
			this.add(l);

		} else if (mode instanceof Path_Finding_Mode)
		{
			JLabel l = new JLabel(
					"Path Finding mit/ohne Flocking m�glich. Mit Mausklick einen Pfad setzen. Der wei�e Kreis setzt den f�r die Boids zu erreichenden Radius");
			l.setForeground(MainApp.FRONT);
			this.add(l);
		} else if (mode instanceof Obstacle_Avoidance_Mode)
		{
			JLabel l = new JLabel(
					"O_A nur mit Flocking m�glich. Gegenst�nde mit Mausklick setzen");
			l.setForeground(MainApp.FRONT);
			this.add(l);
		} else if (mode instanceof Pursuing_Mode)
		{
			JLabel l = new JLabel(
					"Pursuing mit und ohne Flocking m�glich. Mit Mausklick Verfolger generieren, die zuf�lligen Boid jagen");
			l.setForeground(MainApp.FRONT);
			this.add(l);
		} else if (mode instanceof Open_World_Mode)
		{
			JLabel l = new JLabel(
					"In der beigef�gten PDF ist eine Hilfe f�r die Werte zu finden");
			l.setForeground(MainApp.FRONT);
			this.add(l);
			this.add(info);
			this.revalidate();
		}
	}
}