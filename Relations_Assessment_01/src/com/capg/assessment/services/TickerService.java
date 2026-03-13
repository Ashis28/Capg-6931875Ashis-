package com.capg.assessment.services;

import com.capg.assessment.entities.SupportTicket;

public interface TickerService {
	SupportTicket raiseTicket(Long orderId, String issueDescription);
}
