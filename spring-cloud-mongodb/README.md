# distributed-tracing a spring boot mongodb app

This uses an in memory mongodb with Spring Cloud Sleuth to trace events
into Zipkin running on `9411`. 

Sampler probability is set to `1.0` so everything can be traced for test
purposes. 

