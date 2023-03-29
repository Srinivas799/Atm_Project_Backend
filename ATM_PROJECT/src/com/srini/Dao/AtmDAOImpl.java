package com.srini.Dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import com.srini.model.Atm;

public class AtmDAOImpl implements AtmDAO {
	
	private PreparedStatement ps;
	private ResultSet rs;

	@Override
	public boolean Deposite() {
		boolean result = false;
		//Atm atm = null;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br  = new BufferedReader(isr);
		
		try {
			System.out.println("Enter your Phone Number");
			long phone = Long.parseLong(br.readLine());
			
			String query1 = "select Name from atmmoney where phoneNumber = ?";
			ps = con.prepareStatement(query1);
			ps.setLong(1, phone);
			rs = ps.executeQuery();
			
			String nme = null;
			
			if(rs.next())
			{
				nme = rs.getString("Name");
			}
			
			System.out.println(nme+", please enter your 4 digit PIN");
			int pin = Integer.parseInt(br.readLine());
			
			String qry1 = "select AccountNumber from atmmoney where phoneNumber = ?";
			ps = con.prepareStatement(qry1);
			ps.setLong(1, phone);
			rs = ps.executeQuery();
			long account = 0;
			if(rs.next())
			{
				account = rs.getLong("AccountNumber");
			}
			
			String qry = "select Password from atmmoney where AccountNumber = ?";
			ps = con.prepareStatement(qry);
			ps.setLong(1, account);
			rs = ps.executeQuery();
			
			int pinn = 0;
			
			if(rs.next())
			{
				pinn = rs.getInt("Password");
			}
			if(pinn == pin)
			{
				System.out.println(nme+", Please enter the amount to deposite");
				double amount = Double.parseDouble(br.readLine());
				
				String query = "update atmmoney set Balance = Balance + ? where AccountNumber = ?";
				ps = con.prepareStatement(query);
				ps.setDouble(1, amount);
				ps.setLong(2, account);
				ps.execute();
				
				String qury = "insert into atmstore values(?,?,?,?)";
				ps = con1.prepareStatement(qury);
				
				String Status = "Deposite";
				
				ps.setString(1, nme);
				ps.setLong(2, account);
				ps.setDouble(3, amount);
				ps.setString(4, Status);
				ps.execute();
				
				result = true;
				System.out.println(amount+" Deposited Successfully.....");
				
			}
			else
			{
				System.out.println("You have entered wrong PIN");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean Withdraw() {
		//Atm atm = null;
		boolean result = false;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br  = new BufferedReader(isr);
		
		try {
			System.out.println("Enter your Phone Number");
			long phone = Long.parseLong(br.readLine());
			
			String qury = "select Name from atmmoney where phoneNumber = ?";
			ps = con.prepareStatement(qury);
			ps.setLong(1, phone);
			rs = ps.executeQuery();
			
			String nme = null;
			if(rs.next())
			{
				nme = rs.getString("Name");
			}
			String qry1 = "select AccountNumber from atmmoney where phoneNumber = ?";
			ps = con.prepareStatement(qry1);
			ps.setLong(1, phone);
			rs = ps.executeQuery();
			long account = 0;
			if(rs.next())
			{
				account = rs.getLong("AccountNumber");
			}
			System.out.println(nme+", Please enter your 4 digit PIN( "+account+" )");
			int pin = Integer.parseInt(br.readLine());
			
			String qry = "select Password from atmmoney where AccountNumber = ?";
			ps = con.prepareStatement(qry);
			ps.setLong(1, account);
			rs = ps.executeQuery();
			
			int pinn = 0;
			if(rs.next())
			{
				pinn = rs.getInt("Password");
			}
			if(pinn == pin)
			{
				System.out.println(nme+", Please enter the amount to Withdraw");
				double amount = Double.parseDouble(br.readLine());
			
				String query1 = "select Balance from atmmoney where AccountNumber = ? ";
				ps = con.prepareStatement(query1);
				ps.setLong(1, account);
				rs = ps.executeQuery();
			
				double bls = 0;
				if(rs.next())
				{
					bls = rs.getDouble("Balance");
				}
			
				if(bls < amount)
				{
					System.out.println("Rejected ... : due to insufficient funds..");
				}
				else {
					String query = "update atmmoney set Balance = Balance - ? where AccountNumber = ?";
					ps = con.prepareStatement(query);
					ps.setDouble(1, amount);
					ps.setLong(2, account);
					ps.execute();
					
					String qury1 = "insert into atmstore values(?,?,?,?)";
					ps = con1.prepareStatement(qury1);
					
					String Status = "Withdraw";
					
					ps.setString(1, nme);
					ps.setLong(2, account);
					ps.setDouble(3, amount);
					ps.setString(4, Status);
					ps.execute();
					
					result = true;
					System.out.println(amount+" withdrawl Successfully.....");
				}
			}
			else
			{
				System.out.println("You have entred wrong PIN");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean MiniStatement() {
		boolean result = false;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			System.out.println("Please Enter your Phone Number");
			long phone = Long.parseLong(br.readLine());
			
			String query = "select Name from atmmoney where phoneNumber = ?";
			ps = con.prepareStatement(query);
			ps.setLong(1, phone);
			rs = ps.executeQuery();
			
			String nme = null;
			if(rs.next())
			{
				nme = rs.getString("Name");
			}
			
			System.out.println(nme+", Please enter your 4 digit PIN");
			int pin = Integer.parseInt(br.readLine());
			
			String qury = "select Password from atmmoney where phoneNumber = ?";
			ps = con.prepareStatement(qury);
			ps.setLong(1, phone);
			rs = ps.executeQuery();
			
			int pinn = 0;
			
			if(rs.next())
			{
				pinn = rs.getInt("Password");
			}
			
			String qry1 = "select AccountNumber from atmmoney where phoneNumber = ?";
			ps = con.prepareStatement(qry1);
			ps.setLong(1, phone);
			rs = ps.executeQuery();
			
			long account = 0;
			if(rs.next())
			{
				account = rs.getLong("AccountNumber");
			}
			
			if(pinn == pin)
			{
				String qry = "select * from atmstore where AccountNumber = ?";
				ps = con.prepareStatement(qry);
				ps.setLong(1, account);
				rs = ps.executeQuery();
				
				while(rs.next())
				{
					String Name = rs.getString("Name");
					long AccountNumber = rs.getLong("AccountNumber");
					double Balance = rs.getDouble("Balance");
					String Status = rs.getString("Status");
					System.out.println("Name=" + Name + ", AccountNumber= "+ AccountNumber + ", Balance=" + Balance + ", Status= "+ Status);
					result = true;
				}
			}
			else
			{
				System.out.println("You have entered wrong password");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public boolean OpenAccount() {
		boolean result = false;
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br  = new BufferedReader(isr);
			
			System.out.println("Enter Your Name");
			String name = br.readLine();
			System.out.println("Enter Your Phone Number");
			long phone = Long.parseLong(br.readLine());
			System.out.println("Enter your Address");
			String address = br.readLine();
			System.out.println("Set Your PIN number(4 Digits only) ");
			int pin = Integer.parseInt(br.readLine());
			System.out.println("Enter deposite amount");
			double deposite = Double.parseDouble(br.readLine());
			
			String query1 = "select phoneNumber from atmmoney where phoneNumber = ?";
			ps = con.prepareStatement(query1);
			ps.setLong(1, phone);
			rs = ps.executeQuery();
			
			long phn = 0;
			if(rs.next())
			{
				phn = rs.getLong("phoneNumber");
			}
			
			String query2 = "select AccountNumber from atmmoney where phoneNumber = ?";
			ps = con.prepareStatement(query2);
			ps.setLong(1, phone);
			rs = ps.executeQuery();
			long acnt = 0;
			if(rs.next())
			{
				acnt = rs.getLong("AccountNumber");
			}
			if(phone == phn)
			{
				System.out.println("You have a bank account"+"("+ acnt +")"+" on this Phone Number");
			}
			else
			{
				ArrayList<Integer> digits = new ArrayList<Integer>();
				for(int i=1;i<=9;i++)
				{
					digits.add(i);
				}
				Collections.shuffle(digits);
				Random random = new Random();
				long account = 0;
				for(int i=0;i<9;i++)
				{
					account = account * 10 +(long)digits.get(i);
				}
			
				String query = "insert into atmmoney values(?,?,?,?,?,?)";
				ps = con.prepareStatement(query);
			
				ps.setString(1, name);
				ps.setLong(2, phone);
				ps.setLong(3, account);
				ps.setString(4, address);
				ps.setInt(5, pin);
				ps.setDouble(6, deposite);
				ps.execute();
			
				String qury1 = "insert into atmstore values(?,?,?,?)";
				ps = con1.prepareStatement(qury1);
			
				String Status = "Deposite(Opening)";
			
				ps.setString(1, name);
				ps.setLong(2, account);
				ps.setDouble(3, deposite);
				ps.setString(4, Status);
				ps.execute();
			
				result = true;
				System.out.println(name+" your Bank Account opened successfully......");
				System.out.println("Your Account Number is "+account);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public boolean BalanceEnquery() {
		boolean result = false;
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			System.out.println("Please enter your phone Number");
			long phone = Long.parseLong(br.readLine());
			
			String query = "select Name from atmmoney where phoneNumber = ?";
			ps = con.prepareStatement(query);
			ps.setLong(1, phone);
			rs = ps.executeQuery();
			
			String nme = null;
			
			if(rs.next())
			{
				nme = rs.getString("Name");
			}
			
			System.out.println(nme+", Please enter your 4 digit PIN");
			int pin = Integer.parseInt(br.readLine());
			
			String qury = "select Password from atmmoney where phoneNumber = ?";
			ps = con.prepareStatement(qury);
			ps.setLong(1, phone);
			rs = ps.executeQuery();
			
			int pinn = 0;
			if(rs.next())
			{
				pinn = rs.getInt("Password");
			}
			if(pinn == pin)
			{
				String qry = "select * from atmmoney where phoneNumber = ?";
				ps = con.prepareStatement(qry);
				ps.setLong(1, phone);
				rs = ps.executeQuery();
				
				if(rs.next())
				{
					double bls = rs.getDouble("Balance");
					long account = rs.getLong("AccountNumber");
					
					System.out.println(nme+"("+account+")"+", Your Account Balance is "+bls);
					result = true;
				}
			}
			else
			{
				System.out.println("You have entered Worng PIN");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

}
