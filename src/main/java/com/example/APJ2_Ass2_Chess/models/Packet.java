package com.example.APJ2_Ass2_Chess.models;

import java.io.Serializable;


public class Packet implements Serializable {

	private static final long serialVersionUID = 1L;
	private Command com;
	private boolean exit;
	
	public Packet() {
		setCom(null);
		setExit(false);
	}
	
	public Packet(Command command, boolean exit) {
		this.setCom(command);
		this.setExit(exit);
	}

	public Command getCom() {
		return com;
	}

	public void setCom(Command com) {
		this.com = com;
	}

	public boolean isExit() {
		return exit;
	}

	public void setExit(boolean exit) {
		this.exit = exit;
	}
}
