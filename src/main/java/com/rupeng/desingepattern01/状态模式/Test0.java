package com.rupeng.desingepattern01.状态模式;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * 非状态模式，用ifelse实现的状态切换显示
 * @author liuxh
 *
 */
public class Test0 extends  JFrame{

	private JButton btnPay;
	private JButton btnRefund;
	private JButton btnConfirm;
	private JLabel labelState;
	private OrderState state;
	
	public Test0() {
		super("测试");
		setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        JPanel contentPane=new JPanel();
        setContentPane(contentPane);
        
        
        btnPay=new JButton("付款");
        btnPay.addActionListener(new ActionListener() {//付款按钮点击之后执行下面动作
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Test0.this.state==OrderState.UnPayed)
				{
					Test0.this.setState(OrderState.Payed);	
				}
				else if(Test0.this.state==OrderState.Payed)
				{
					throw new RuntimeException("已经支付，不需要重复支付");
				}
				else if(Test0.this.state==OrderState.Refund)
				{
					throw new RuntimeException("已退款，不能支付");
				}
				else if(Test0.this.state==OrderState.Confirmed)
				{
					throw new RuntimeException("已确认，不能支付");
				}
				else
				{
					throw new RuntimeException("未知的OrderState");
				}
						
			}
		});
        
        btnRefund=new JButton("退款");
        btnRefund.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Test0.this.state==OrderState.UnPayed)
				{
					throw new RuntimeException("未支付，不能退款");
				}
				else if(Test0.this.state==OrderState.Payed)
				{
					Test0.this.setState(OrderState.Refund);	
				}
				else if(Test0.this.state==OrderState.Refund)
				{
					throw new RuntimeException("已经退款，不能重复退款");
				}
				else if(Test0.this.state==OrderState.Confirmed)
				{
					throw new RuntimeException("已经确认，不能退款");
				}
				else
				{
					throw new RuntimeException("未知的OrderState");
				}				
					
			}
		});

        btnConfirm=new JButton("确认收货");
        btnConfirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Test0.this.state==OrderState.UnPayed)
				{
					throw new RuntimeException("未支付，不能确认");
				}
				else if(Test0.this.state==OrderState.Payed)
				{
					Test0.this.setState(OrderState.Confirmed);	
				}
				else if(Test0.this.state==OrderState.Refund)
				{
					throw new RuntimeException("已经退款，不能确认");
				}
				else if(Test0.this.state==OrderState.Confirmed)
				{
					throw new RuntimeException("已经确认，不能重复确认");
				}
				else
				{
					throw new RuntimeException("未知的OrderState");
				}				
					
			}
		});
        
        labelState = new JLabel();
        GridLayout gird=new GridLayout(3,3); 
        contentPane.setLayout(gird);

        contentPane.add(btnPay); 
        contentPane.add(btnRefund);
        contentPane.add(btnConfirm);
        contentPane.add(labelState);
        
        setState(OrderState.UnPayed);
	}
	
	public void setState(OrderState stat)
	{		
		this.state = stat;
		if(this.state==OrderState.UnPayed)
		{
			this.btnConfirm.setEnabled(false);
			this.btnPay.setEnabled(true);
			this.btnRefund.setEnabled(false);
			this.labelState.setText("未支付");
		}
		else if(this.state==OrderState.Payed)
		{
			this.btnConfirm.setEnabled(true);
			this.btnPay.setEnabled(false);
			this.btnRefund.setEnabled(true);
			this.labelState.setText("已支付");
		}
		else if(this.state==OrderState.Refund)
		{
			this.btnConfirm.setEnabled(false);
			this.btnPay.setEnabled(false);
			this.btnRefund.setEnabled(false);
			this.labelState.setText("已退款");
		}
		else if(this.state==OrderState.Confirmed)
		{
			this.btnConfirm.setEnabled(false);
			this.btnPay.setEnabled(false);
			this.btnRefund.setEnabled(false);
			this.labelState.setText("确认收货");
		}
		else
		{
			throw new RuntimeException("未知的OrderState");
		}
	}
	
	public static void main(String[] args) {
		Test0  t =new Test0();
		t.pack();
	}
}

