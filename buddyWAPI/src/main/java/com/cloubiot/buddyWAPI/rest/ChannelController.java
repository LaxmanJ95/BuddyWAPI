package com.cloubiot.buddyWAPI.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cloubiot.buddyWAPI.base.SuccessResponse;
import com.cloubiot.buddyWAPI.common.CloubiotLogging;
import com.cloubiot.buddyWAPI.model.channel.ChannelListResponse;
import com.cloubiot.buddyWAPI.model.channel.ChannelRequest;
import com.cloubiot.buddyWAPI.model.dbentity.Channel;
import com.cloubiot.buddyWAPI.service.ChannelService;

@RestController
@RequestMapping("/channel")
public class ChannelController {

	@Autowired
	ChannelService channelService;
	
	@RequestMapping(method = RequestMethod.POST, value="/addUpdateChannel")
	public SuccessResponse addUpdateChannel(@RequestBody ChannelRequest request) {
		SuccessResponse response = new SuccessResponse();
		try {
			channelService.saveChannel(request.getChannel());
			CloubiotLogging.logInfo(getClass(), "Channel Updated");
		}
		catch(Exception e) {
			CloubiotLogging.logError(getClass(), "Channel Updated failed", e);
			response.setSuccess(false);	
		}
		return response;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="getChannels")
	public ChannelListResponse getChannels() {
		ChannelListResponse response = new ChannelListResponse();
		try {
			List<Channel> channel = channelService.getAllChannels();
			CloubiotLogging.logInfo(getClass(), "Channel List");
		}
		catch(Exception e) {
			CloubiotLogging.logError(getClass(), "Channel List failed", e);
			response.setSuccess(false);
		}
		return response;
	}
}
