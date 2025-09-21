CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE tenant (
  id uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
  name text not null,
  timezone text,
  enabled_plugins jsonb DEFAULT '[]',
  created_at timestamptz DEFAULT now()
);

CREATE TABLE plugin (
  id text PRIMARY KEY,
  display_name text,
  version text,
  active boolean DEFAULT true
);

CREATE TABLE invoice (
  id uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
  tenant_id uuid REFERENCES tenant(id),
  invoice_number text,
  amount numeric,
  tax numeric,
  status text,
  created_at timestamptz DEFAULT now()
);
