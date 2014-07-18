namespace java com.fourtwosix.codahale.metrics.thrift

struct HealthCheckResultError
{
  1: required string message;
  2: required list<string> stack;
}

struct HealthCheckResult
{
  1: required bool healthy;
  2: optional string message;
  3: optional list<HealthCheckResultError> error;
}
