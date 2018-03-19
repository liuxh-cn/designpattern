package com.rupeng.desingepattern01.状态模式2;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * 将IOrderState及其实现类写成内部类，为了方便操作Test里private的JButton对象
 * @author liuxh
 *
 */
public class Test extends  JFrame{

	private JButton btnPay;
	private JButton btnRefund;
	private JButton btnConfirm;
	private JLabel labelState;
	private IOrderState state;
	
	public Test() {
		super("测试");
		setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        JPanel contentPane=new JPanel();
        setContentPane(contentPane);        
          
        btnPay=new JButton("付款");
        btnPay.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				Test.this.state.pay();				
			}
		});
        
        btnRefund=new JButton("退款");
        btnRefund.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				Test.this.state.refund();	
			}
		});

        btnConfirm=new JButton("确认收货");
        btnConfirm.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				Test.this.state.confirm();	
			}
		});
        
        labelState = new JLabel();
        GridLayout gird=new GridLayout(3,3);
        contentPane.setLayout(gird);

        contentPane.add(btnPay);
        contentPane.add(btnRefund);
        contentPane.add(btnConfirm);
        contentPane.add(labelState);        
        setState(new UnPayedState());
	}
	
	public void setState(IOrderState stat)
	{		
		this.state = stat;
		this.state.updateUI();
	}
	
	public static void main(String[] args) {
		Test  t =new Test();
		t.pack();
	}
	
	interface IOrderState
	{
		//更新界面状态
		void updateUI();
		void pay();
		void refund();
		void confirm();
	}
	class UnPayedState implements IOrderState
	{

		@Override
		public void updateUI() {
			Test.this.btnConfirm.setEnabled(false);
			Test.this.btnPay.setEnabled(true);
			Test.this.btnRefund.setEnabled(false);
			Test.this.labelState.setText("未支付");
		}

		@Override
		public void pay() {
			Test.this.setState(new PayedState());			
		}

		@Override
		public void refund() {
			throw new RuntimeException("未付款无法退款");			
		}

		@Override
		public void confirm() {
			throw new RuntimeException("未付款无法确认");				
		}
		
	}
	
	class PayedState implements IOrderState
	{

		@Override
		public void updateUI() {
			Test.this.btnConfirm.setEnabled(true);
			Test.this.btnPay.setEnabled(false);
			Test.this.btnRefund.setEnabled(true);
			Test.this.labelState.setText("已支付");			
		}

		@Override
		public void pay() {
			throw new RuntimeException("已经支付，不需要重复支付");	
		}

		@Override
		public void refund() {
			Test.this.setState(new UnPayedState());			
		}

		@Override
		public void confirm() {
			Test.this.setState(new ConfirmedState());			
		}
		
	}
	class RefundedState implements IOrderState
	{

		@Override
		public void updateUI() {
			Test.this.btnConfirm.setEnabled(false);
			Test.this.btnPay.setEnabled(false);
			Test.this.btnRefund.setEnabled(false);
			Test.this.labelState.setText("已退款");
			
		}

		@Override
		public void pay() {
			throw new RuntimeException("已经退款，无法支付");		
		}

		@Override
		public void refund() {
			throw new RuntimeException("已经退款，不能重复退款");				
		}

		@Override
		public void confirm() {
			throw new RuntimeException("已经退款，不能确认");				
		}
		
	}
	
	class ConfirmedState implements IOrderState
	{
		@Override
		public void updateUI() {
			Test.this.btnConfirm.setEnabled(false);
			Test.this.btnPay.setEnabled(false);
			Test.this.btnRefund.setEnabled(false);
			Test.this.labelState.setText("确认收货");
			
		}

		@Override
		public void pay() {
			throw new RuntimeException("已经确认，不能重复支付");				
		}

		@Override
		public void refund() {
			throw new RuntimeException("已经确认，不能退款");		
		}

		@Override
		public void confirm() {
			throw new RuntimeException("已经确认，不能重复确认");
			
		}
		
	}
}

